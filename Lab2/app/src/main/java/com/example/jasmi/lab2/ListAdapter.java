package com.example.jasmi.lab2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.min;

/**
 * Created by jasmi on 2018-11-29.
 */

/////STOOOOOOOOOOOOOOOOOOOOOOOOOP

public class ListAdapter implements ExpandableListAdapter {

    private Context context;
    private List<String> listTitle;
    private HashMap<String, List<String>> listDetail;
    private int lastExpandaded = -1;

    public ListAdapter(Context cont, List<String> expListTitle, HashMap<String, List<String>> expListDetail){

        context = cont;
        listTitle = expListTitle;
        listDetail = expListDetail;

    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }


    @Override
    public int getGroupCount() {
        return this.listTitle.size();
    }

    @Override
    public int getChildrenCount(int listPos) {
        return this.listDetail.get(this.listTitle.get(listPos)).size();
    }

    @Override
    public Object getGroup(int listPos) {
        return this.listTitle.get(listPos);
    }

    @Override
    public Object getChild(int listPos, int expListPos) {
        return this.listDetail.get(this.listTitle.get(listPos)).get(expListPos);
    }

    @Override
    public long getGroupId(int listPos) {
        return listPos;
    }

    @Override
    public long getChildId(int listPos, int expListPos) {
        return expListPos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getGroupView(int listPos, boolean isExpanded, View convertView, ViewGroup parent) {

        String listTitle = (String) getGroup(listPos);
        if(convertView == null){
            LayoutInflater layoutInf = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInf.inflate(R.layout.list_group, null);
        }

        TextView titleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        titleTextView.setTypeface(null, Typeface.BOLD);
        titleTextView.setText(listTitle);

        return convertView;
    }

    @Override
    public View getChildView(int listPos, int expListPos, boolean lastChild, View convertView, ViewGroup parent) {
        final String expListText = (String) getChild(listPos, expListPos);

        if(convertView == null)
        {
            LayoutInflater layoutInf = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInf.inflate(R.layout.list_item, null);
        }

        TextView expListTextView = (TextView) convertView.findViewById(R.id.expListItem);
        expListTextView.setText(expListText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int i) {

    }

    @Override
    public void onGroupCollapsed(int i) {

    }

    @Override
    public long getCombinedChildId(long l, long l1) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long l) {
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    public void filterData(String query, EditText searchWay, ExpandableListView listView)
    {
        //Make query to Lower case
        String orgQuery = query;
        query = query.toLowerCase();

        //Check if query is empty, then set the text to "/" and make searchfield white
        if(query.isEmpty())
        {
            //Unmark everyone
            Log.v("FilterData", "Query is empty");
            searchWay.setText("/");
            searchWay.setSelection(1);
            searchWay.setBackgroundColor(Color.WHITE);
        }
        //Query contains text
        else
        {
            System.out.println("Query is: " + query);
            boolean found = false;
            //Removes first letter in query since it is a "/"
            if(query.charAt(0) == '/')
                query = query.substring(1);


            //Loops through all parents in lists
            for (HashMap.Entry<String, List<String>> list : listDetail.entrySet()) {

                List<String> indexes = new ArrayList<String>(listDetail.keySet());

                //Make query and list the same length to be able to compare them
                String comparableQuery = query.substring(0,min(query.length(), list.getKey().length()));
                String comparableList = list.getKey().substring(0,min(query.length(), list.getKey().length()));

                //Check if query and list starts the same way
                if(comparableQuery.equals(comparableList)){
                    found = true;

                    //Check if they have the same length, then we found the right searchway, mark item and expand list
                    if(list.getKey().length() == query.length())
                    {
                        searchWay.setBackgroundColor(Color.WHITE);
                        found = true;

                        int index = listView.getFlatListPosition(listView.getPackedPositionForGroup(indexes.indexOf(list.getKey())));
                        int expand = indexes.indexOf(list.getKey());
                        System.out.println("Index to be marked: " + index);
                        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

                        listView.setItemChecked(index, true);

                        //Check if list is not expanded, collapse the old list and expand the current
                        if(!listView.isGroupExpanded(expand)) {// && lastExpandaded != index) {

                            System.out.println("lastExpandaded in parent is " + lastExpandaded);
                            if(lastExpandaded != -1)
                            {
                                System.out.println("Collapsing group: " + lastExpandaded);
                                listView.collapseGroup(lastExpandaded);

                            }

                            lastExpandaded = expand;
                            listView.expandGroup(expand); //Position of the titles
                        }


                        searchWay.setSelection(orgQuery.length());

                    }
                    //The text is not finished yet, wait for more input
                    else if(list.getKey().length() > query.length()){
                        searchWay.setBackgroundColor(Color.WHITE);
                        Log.v("Headline", "Wait for more input");

                    }
                    //Parent is the same, check if the query is the same as the child
                    else
                    {
                        int index = listView.getFlatListPosition(listView.getPackedPositionForGroup(indexes.indexOf(list.getKey())));
                        if(query.charAt(list.getKey().length()) == '/')
                        {
                            String queryColor = query.substring(list.getKey().length() + 1);
                            Boolean foundChild = false;
                            for (int i = 0; i < list.getValue().size(); i++) {
                                String color = list.getValue().get(i);


                                //Make query and list the same length to be able to compare them
                                String comparableQueryColor = queryColor.substring(0, min(queryColor.length(), list.getValue().get(i).length()));
                                String comparableListColor = list.getValue().get(i).substring(0, min(queryColor.length(), list.getValue().get(i).length()));
                                //Log.v("FilterData", "Loop through Lis" + comparableQueryColor + comparableListColor);
                                if (comparableQueryColor.isEmpty()) {
                                    Log.v("FilterData", "Empty subItem");
                                    foundChild = true;
                                    searchWay.setBackgroundColor(Color.WHITE);

                                }
                                //Check if query and list starts the same way
                                else if (comparableQueryColor.equals(comparableListColor)) {

                                    //Check if they have the same length, then we found the right searchway, mark item and set sarchway to white
                                    if (color.length() == queryColor.length()) {
                                        Log.v("Headline", "Found right searchway for subItem in list");
                                        foundChild = true;
                                        searchWay.setBackgroundColor(Color.WHITE);
                                        int indexChild = listView.getFlatListPosition(listView.getPackedPositionForChild(indexes.indexOf(list.getKey()), i));
                                        System.out.println("IndexChild to be marked: " + indexChild);
                                        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

                                        listView.setItemChecked(indexChild, true);

                                        searchWay.setSelection(orgQuery.length());
                                    //Query is not fully filled yet, wait for more input and searchway is white
                                    } else if (color.length() > queryColor.length()) {
                                        foundChild = true;
                                        searchWay.setBackgroundColor(Color.WHITE);

                                    }
                                    //Input is wrong, turns the searchway red
                                    else {
                                        searchWay.setBackgroundColor(Color.RED);
                                        int indexChild = listView.getFlatListPosition(listView.getPackedPositionForChild(indexes.indexOf(list.getKey()), i));

                                        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

                                        listView.setItemChecked(indexChild, false);


                                    }

                                }

                            }

                            if(foundChild == false)
                                found = false;
                        }
                        //Wrong search way
                        else
                        {
                            //Markera sökvägen röd
                            //Avmarkera noder
                            int indexChild = listView.getFlatListPosition(listView.getPackedPositionForGroup(indexes.indexOf(list.getKey())));
                            System.out.println("Index to be marked: " + indexChild);
                            listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

                            listView.setItemChecked(indexChild, false);
                        }
                    }

                }


            }
            if(!found){
                //Mark search field red
                searchWay.setBackgroundColor(Color.RED);
                Log.v("FilterData", "Do not exist");

            }

        }


    }
}

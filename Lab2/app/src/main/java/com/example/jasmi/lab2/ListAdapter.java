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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.min;

/**
 * Created by jasmi on 2018-11-29.
 */

public class ListAdapter implements ExpandableListAdapter {

    private Context context;
    private List<String> listTitle;
    private HashMap<String, List<String>> listDetail;

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
    public void filterData(String query, TextView searchWay, ExpandableListView listView)
    {
        query = query.toLowerCase();
                                            //SetItemChecked
                                            //GetFlatIndexPosition
                                            // KOLLA MER PÅ DETTA NÄR NI VILL MARKERA SAKER
                                            //int index = expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForChild(i, i1));
                                            //Toast.makeText(getApplicationContext(), String.valueOf(index), Toast.LENGTH_SHORT).show();
                                            //expandableListView.setItemChecked(index, true);

        if(query.isEmpty())
        {
            //Unmark everyone
            Log.v("FilterData", "Query is empty");
            searchWay.setText("/");
            searchWay.setBackgroundColor(Color.WHITE);
        }
        else
        {
            query = query.substring(1);
            boolean found = false;
            for (HashMap.Entry<String, List<String>> list : listDetail.entrySet()) {

                List<String> indexes = new ArrayList<String>(listDetail.keySet());
                //Kolla om rubriken är satt till string

                //Make query and list the same length to be able to compare them
                String comparableQuery = query.substring(0,min(query.length(), list.getKey().length()));
                String comparableList = list.getKey().substring(0,min(query.length(), list.getKey().length()));

                //Check if query and list starts the same way
                if(comparableQuery.equals(comparableList)){
                    found = true;


                    //Check if they have the same length, then we found the right searchway
                    if(list.getKey().length() == query.length())
                    {
                        //Mark the current list Item
                        //Search way set to white
                        searchWay.setBackgroundColor(Color.WHITE);
                        found = true;
                        Log.v("Headline", "Head list item should be marked");

                        int index = listView.getFlatListPosition(listView.getPackedPositionForGroup(indexes.indexOf(list.getKey())));
                        System.out.println("Index to be marked: " + index);
                        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

                        listView.setItemChecked(index, true);


                        //listView.expandGroup(indexes.indexOf(list.getKey())); //Position of the titles
                    }
                    //The text is not finished yet, wait for more input
                    else if(list.getKey().length() > query.length()){
                        //Senaste noden ska vara markerad
                        //Sökfältets bakgrundsfärg vit
                        searchWay.setBackgroundColor(Color.WHITE);
                        Log.v("Headline", "Wait for more input");

                    }
                    //Check if the query is the same as the child
                    else
                    {
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

                                    Log.v("FilterData", "They are the same");
                                    System.out.println("They are the same");
                                    //Check if they have the same length, then we found the right searchway
                                    if (color.length() == queryColor.length()) {
                                        //Found the right search way
                                        //Set searchway to White
                                        //Mark the item in the list
                                        Log.v("Headline", "Found right searchway for subItem in list");
                                        foundChild = true;
                                        searchWay.setBackgroundColor(Color.WHITE);
                                        int index = listView.getFlatListPosition(listView.getPackedPositionForChild(indexes.indexOf(list.getKey()), i));
                                        System.out.println("Index to be marked: " + index);
                                        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

                                        listView.setItemChecked(index, true);

                                    } else if (color.length() > queryColor.length()) {
                                        //Wait for more input
                                        //Searchway is white
                                        Log.v("Headline", "Waiting for more input for subItem");
                                        foundChild = true;
                                        searchWay.setBackgroundColor(Color.WHITE);

                                    } else {
                                        //Wrong input
                                        //Searchway is red
                                        Log.v("Headline", "Input is too long");
                                        searchWay.setBackgroundColor(Color.RED);
                                        int index = listView.getFlatListPosition(listView.getPackedPositionForChild(indexes.indexOf(list.getKey()), i));
                                        System.out.println("Index to be marked: " + index);
                                        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

                                        listView.setItemChecked(index, false);


                                    }

                                }

                            }
                            if(foundChild == false)
                                found = false;
                        }
                        else
                        {
                            //Markera sökvägen röd
                            //Avmarkera noder
                            int index = listView.getFlatListPosition(listView.getPackedPositionForGroup(indexes.indexOf(list.getKey())));
                            System.out.println("Index to be marked: " + index);
                            listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

                            listView.setItemChecked(index, false);
                        }
                    }





                }
                else{
                    //Markera sökvägen röd
                    //Avmarkera noder

                }


                //Log.v("FilterData", "Loop through hashmap");


            }
            if(!found){
                //Mark search field red
                searchWay.setBackgroundColor(Color.RED);
                Log.v("FilterData", "Do not exist");

            }

        }


    }
}

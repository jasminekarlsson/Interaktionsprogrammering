package com.example.jasmi.lab2;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

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
}

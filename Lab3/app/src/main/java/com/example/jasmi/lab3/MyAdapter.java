package com.example.jasmi.lab3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by jasmi on 2018-12-19.
 */

public class MyAdapter extends BaseAdapter{

    private List<String> nameList;
    Context context;

    public MyAdapter(Context c, List<String> names){
        nameList = names;
        context = c;
    }

    public void setList(List<String> names) {
        nameList.clear();
        nameList.addAll(names);
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return nameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        return null;
    }
}

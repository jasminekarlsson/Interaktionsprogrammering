package com.example.rebecka.lab3;

import android.content.Context;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasmi on 2018-12-18.
 */

//Ska också ha en extend View, override onDraw, onMeasure

public class InteractiveSearcher extends android.support.v7.widget.AppCompatEditText{

    private ListPopupWindow popName;
    private MyAdapter adapter;
    private int id = 1;
    private Context context;

    public InteractiveSearcher(Context c) {
        context = c;
        List<String> tmp = new ArrayList<String>();
        adapter = new MyAdapter(context, tmp);
        //MyAdapter adapter = new MyAdapter(context, tmp);
        //System.out.println("Adapter count in Interactive: " + adapter.getCount());
        init();
    }

    private void init(){
        setEms(10);
        setHint("Search...");

        //add text watcher on the object
        //this.addTextChangedListener((TextWatcher) onTextChanged);

        //Create a list popup window to display the result
        popName = new ListPopupWindow(context);
        popName.setAnchorView(this);
        popName.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id){
                //get value from list
                setText(adapterView.getItemAtPosition(pos).toString());
            }
        });
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count){

        id = id + 1;
        String query = s.toString().toLowerCase();
        String url = "https://andla.pythonanywhere.com/getnames/" + id + "/" + query;
        String[] send = new String[2];
        send[0] = url;
        send[1] = String.valueOf(id);
        new dataAsync(adapter, popName).execute(send);


    }

    private void getData(String query) throws IOException {

    }



}
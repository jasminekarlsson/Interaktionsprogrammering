package com.example.jasmi.lab3;

import android.content.Context;
import android.support.v7.widget.ListPopupWindow;
import com.example.jasmi.lab3.dataAsync;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jasmi on 2018-12-18.
 */

//Ska också ha en extend View, override onDraw, onMeasure

public class InteractiveSearcher extends android.support.v7.widget.AppCompatEditText{

    private ListPopupWindow popName;
    private MyAdapter adapter;
    private int id = 1;

    public InteractiveSearcher(Context context) {
        super(context);
        List<String> tmp = new ArrayList<String>();
        //MyAdapter adapter = new MyAdapter(context, tmp);
        //System.out.println("Adapter count in Interactive: " + adapter.getCount());

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
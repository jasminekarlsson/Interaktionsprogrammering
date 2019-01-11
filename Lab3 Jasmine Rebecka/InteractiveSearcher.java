package com.example.jasmi.lab3;

import android.content.Context;
import android.support.v7.widget.ListPopupWindow;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;

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
    private int id = 1;
    private Context context;
    int nrOfNames;

    //Constructor when no number of names are selected. Sets  default to 5 names.
    public InteractiveSearcher(Context c) {
        super(c);
        context = c;
        this.nrOfNames = 5;
        init();
    }

    //Constructor with specified insert of max numbers of names to display
    public InteractiveSearcher(Context context, int nrOfNames){
        super(context);
        this.context = context;
        this.nrOfNames = nrOfNames;
        init();
    }

    private void init(){
        setEms(10);
        setHint("Search...");

        //Add text watcher on the object
        this.addTextChangedListener((TextWatcher) changedText);

        //Create a list popup window to display the result
        popName = new ListPopupWindow(context);
        popName.setAnchorView(this);
        popName.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id){
                //Get value from list
                setText(adapterView.getItemAtPosition(pos).toString());
            }
        });
    }

    private TextWatcher changedText = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        public void afterTextChanged(Editable s) {
            id = id + 1;
            String query = s.toString().toLowerCase();
            String url = "https://andla.pythonanywhere.com/getnames/" + id + "/" + query;
            String[] send = new String[2];
            send[0] = url;
            send[1] = String.valueOf(id);
            //new dataAsync(adapter, popName).execute(send);
            new dataAsync(context, popName, nrOfNames).execute(send);
        }
    };

    private void getData(String query) throws IOException {

    }
}
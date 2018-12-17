package com.example.jasmi.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/////STOOOOOOOOOOOOOOOOOOOOOOOOOP

public class MainActivity extends AppCompatActivity {


    boolean clicked = false;
    int lastExpanded = -1;
    public  HashMap<String, List<String>> getData(){
        HashMap<String, List<String>> listDetail = new HashMap<String, List<String>>();

        List<String> light=  new ArrayList<String>();
        light.add("blue");
        light.add("green");
        light.add("pink");

        List<String> medium=  new ArrayList<String>();
        medium.add("green");
        medium.add("yellow");
        medium.add("red");
        medium.add("blue");

        List<String> dark=  new ArrayList<String>();
        dark.add("purple");
        dark.add("green");
        dark.add("blue");

        listDetail.put("light", light);
        listDetail.put("medium", medium);
        listDetail.put("dark", dark);
        return listDetail;
    }

    public void setWhite(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final HashMap<String, List<String>> listDetail = getData();
        final List<String> expandableListTitle = new ArrayList<String>(listDetail.keySet());
        final EditText searchField = (EditText) findViewById(R.id.searchway);
        final ExpandableListView listView = (ExpandableListView) findViewById(R.id.listview); //Finds listView

        final ListAdapter listAdapter = new ListAdapter(this, expandableListTitle, listDetail);
        listView.setAdapter(listAdapter);



        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPos) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPos) + "List expanded", Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPos) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPos) + "List collapsed", Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPos, int childPos, long id) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPos) + " -> " + listDetail.get(
                        expandableListTitle.get(groupPos)).get(childPos), Toast.LENGTH_SHORT).show();

                String child = listDetail.get(expandableListTitle.get(groupPos)).get(childPos);
                String par = expandableListTitle.get(groupPos);
                int indexChild = listView.getFlatListPosition(listView.getPackedPositionForChild(groupPos, childPos));
                listView.setItemChecked(indexChild, true);

                TextView searchWay = (TextView) findViewById(R.id.searchway);
                clicked = true;
                searchWay.setText("/" + par + "/" + child);
                searchField.setSelection(searchWay.getText().length());

                return false;
            }
        });

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView listV, View view, int groupPos, long id) {
                String par = expandableListTitle.get(groupPos);
                TextView searchWay = (TextView) findViewById(R.id.searchway);
                int index = listView.getFlatListPosition(listView.getPackedPositionForGroup(groupPos));
                listView.setItemChecked(index, true);

                System.out.println("SETONGROUPCLICK: has parent" + par);
                clicked = true;
                searchWay.setText("/" + par);
                searchField.setSelection(searchWay.getText().length());
                return false;
            }
        });

        searchField.addTextChangedListener(new TextWatcher(){

            public void afterTextChanged(Editable s) {
                EditText searchWay = (EditText) findViewById(R.id.searchway);
                String text = searchField.getText().toString();
                if (!clicked)
                    listAdapter.filterData(text, searchWay, listView);
                else{
                    clicked = false;
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });






    }
}

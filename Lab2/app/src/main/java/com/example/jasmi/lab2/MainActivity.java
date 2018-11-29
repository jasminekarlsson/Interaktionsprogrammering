package com.example.jasmi.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class MainActivity extends AppCompatActivity {


    public  HashMap<String, List<String>> getData(){
        HashMap<String, List<String>> listDetail = new HashMap<String, List<String>>();

        List<String> light=  new ArrayList<String>();
        light.add("Blue");
        light.add("Green");
        light.add("Pink");

        List<String> medium=  new ArrayList<String>();
        medium.add("Green");
        medium.add("Yellow");
        medium.add("Red");
        medium.add("Blue");

        List<String> dark=  new ArrayList<String>();
        dark.add("Purple");
        dark.add("Green");
        dark.add("Blue");

        listDetail.put("Light", light);
        listDetail.put("Medium", medium);
        listDetail.put("Dark", dark);
        return listDetail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listview);
        final HashMap<String, List<String>> listDetail = getData();
        final List<String> expandableListTitle = new ArrayList<String>(listDetail.keySet());
        ExpandableListAdapter listAdapter = new ListAdapter(this, expandableListTitle, listDetail);
        listView.setAdapter(listAdapter);
        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPos) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPos) + "List expanded", Toast.LENGTH_SHORT).show();

                String par = expandableListTitle.get(groupPos);
                TextView searchWay = (TextView) findViewById(R.id.searchway);
                searchWay.setText("/" + par);
                
                TextView text = (TextView) findViewById(R.id.listTitle);
                text.setBackgroundResource(R.color.colorAccent);
            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPos) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPos) + "List collapsed", Toast.LENGTH_SHORT).show();

                String par = expandableListTitle.get(groupPos);

                TextView searchWay = (TextView) findViewById(R.id.searchway);
                searchWay.setText("/" + par);

            }
        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPos, int childPos, long id) {
                Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPos) + " -> " + listDetail.get(
                        expandableListTitle.get(groupPos)).get(childPos), Toast.LENGTH_SHORT).show();

                String child = listDetail.get(expandableListTitle.get(groupPos)).get(childPos);
                String par = expandableListTitle.get(groupPos);

                TextView searchWay = (TextView) findViewById(R.id.searchway);
                searchWay.setText("/" + par + "/" + child);

                //TextView text = (TextView) findViewById(R.id.expListItem);
                //text.setBackgroundResource(R.color.colorAccent);



                return false;
            }
        });







    }
}

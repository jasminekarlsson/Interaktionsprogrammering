package com.example.rebecka.lab3;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.ListPopupWindow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import static java.lang.Long.min;

/**
 * Created by jasmi on 2018-12-18.
 */

public class dataAsync extends AsyncTask<String, Void, String> {

    MyAdapter adapter;
    ListPopupWindow popupWindow;
    int lastID;
    Context context;
    HashMap<Integer, List<String>> nameList = new HashMap<Integer, List<String>>(); //key = id Entry = list of names

    dataAsync(MyAdapter adapt, ListPopupWindow popup){
        adapter = adapt;
        popupWindow = popup;
        //System.out.println("Adapter count: " + adapter.getCount());
    }

    @Override
    protected String doInBackground(String... str) {
        String query = (String) str[0];
        String id = str[1];

        if(query.length() > 0) {
            lastID = Integer.parseInt(id);
            URL url = null;
            String line = "";
            int dataID;
            String names = "";
            HttpsURLConnection urlConnection = null;

            try {
                url = new URL(query);
                System.out.println(url);
                urlConnection = (HttpsURLConnection) url.openConnection();
                BufferedReader in = null;

                in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                while ((line = in.readLine()) != null) {
                    names = names + line;
                }

                System.out.println(names);

                in.close();
                return names;

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                urlConnection.disconnect();
            }


        }
        return null;
    }


    @Override
    protected void onPostExecute(String result){
        System.out.println("In onPostExecute");
        if(result !=  null)
        {
            List<String> tmpnames = new ArrayList<String>();
            try {
                JSONObject jsonformat = new JSONObject(result);
                JSONArray names = jsonformat.getJSONArray("result");
                int id = jsonformat.getInt("id");
                if(id == lastID){
                    for (int i = 0; i < min(5, names.length()) ; i++) {
                        tmpnames.add(String.valueOf(names.get(i)));
                        System.out.println("TMPNAMES: " + tmpnames.get(i) + "adapter ");
                    }

                    if(tmpnames != null && adapter != null)
                        //right order

                        nameList.put(lastID, tmpnames);
                        adapter = new MyAdapter(context, nameList.get(lastID));
                        //adapter = new MyAdapter(context, tmpnames);
                        //adapter.setList(tmpnames);
                        popupWindow.setAdapter(adapter);
                        popupWindow.show();

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}


package com.example.jasmi.project;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        RegistrationForm form = new RegistrationForm(this);
        RelativeLayout.LayoutParams formParams =  new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                                                        RelativeLayout.LayoutParams.WRAP_CONTENT );

        layout.addView(form, formParams);


        setContentView(layout);


    }



}

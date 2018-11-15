package com.example.jasmi.lab1;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import static android.widget.LinearLayout.*;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout myLayout = new LinearLayout(this);
        LinearLayout.LayoutParams wrapChild = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams fillParent = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams fillParentFull = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


        myLayout.setOrientation(1);
        //myLayout.setGravity(Gravity.CENTER);
        //myLayout.setVerticalGravity(Gravity.CENTER);
        myLayout.setHorizontalGravity(Gravity.CENTER);

        Button myButton = new Button(this);
        myButton.setText("Knapp");

        EditText editText = new EditText(this);
        editText.setText("Textfält");
        editText.setMaxLines(1);

        RatingBar stars = new RatingBar(this);
        stars.setNumStars(5);

        EditText textRows = new EditText(this);


        myLayout.addView(myButton, -1,  fillParent);
        myLayout.addView(editText, -1, fillParent);
        //myLayout.addView(stars);
        myLayout.addView(stars, -1, wrapChild);
        myLayout.addView(textRows, -1 , fillParentFull);
        //setContentView(myLayout);

        setContentView(R.layout.activity_main);
    }
}

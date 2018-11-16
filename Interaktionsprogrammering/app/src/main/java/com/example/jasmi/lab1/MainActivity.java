package com.example.jasmi.lab1;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import static android.widget.LinearLayout.*;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongConstant")

    protected  LinearLayout lab1(LinearLayout myLayout){
        LinearLayout.LayoutParams wrapChild = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams fillParent = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams fillParentFull = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


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

        return myLayout;
    }

    protected  GridLayout  lab2(GridLayout myLayout){

        myLayout.setColumnCount(2);
        myLayout.setRowCount(4);


        EditText nameField = new EditText(this);
        nameField.setMaxLines(1);
        nameField.setWidth(500);

        EditText passField = new EditText(this);
        passField.setMaxLines(1);

        EditText emailField = new EditText(this);
        emailField.setMaxLines(1);

        TextView name = new TextView(this);
        name.setText("Namn");

        TextView password = new TextView(this);
        password.setText("Lösenord");

        TextView email = new TextView(this);
        email.setText("Epost");

        TextView age = new TextView(this);
        age.setText("Ålder");

        myLayout.addView(name,new GridLayout.LayoutParams(
                GridLayout.spec(0, GridLayout.CENTER),
                GridLayout.spec(0, GridLayout.CENTER)));

        myLayout.addView(nameField, new GridLayout.LayoutParams(
                GridLayout.spec(0, GridLayout.LEFT),
                GridLayout.spec(1, GridLayout.LEFT)));

        myLayout.addView(password, new GridLayout.LayoutParams(
                GridLayout.spec(1, GridLayout.CENTER),
                GridLayout.spec(0, GridLayout.CENTER)));
        myLayout.addView(passField, new GridLayout.LayoutParams(
                GridLayout.spec(1, GridLayout.LEFT),
                GridLayout.spec(1, GridLayout.LEFT)));

        myLayout.addView(email, new GridLayout.LayoutParams(
                GridLayout.spec(2, GridLayout.CENTER),
                GridLayout.spec(0, GridLayout.CENTER)));
        myLayout.addView(emailField, new GridLayout.LayoutParams(
                GridLayout.spec(2, GridLayout.LEFT),
                GridLayout.spec(1, GridLayout.LEFT)));

        myLayout.addView(age, new GridLayout.LayoutParams(
                GridLayout.spec(3, GridLayout.CENTER),
                GridLayout.spec(0, GridLayout.CENTER)));

        return myLayout;

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(1);
        myLayout.setHorizontalGravity(Gravity.CENTER);

        GridLayout secondLayout = new GridLayout(this);
        secondLayout.setOrientation(1);
        secondLayout.setMinimumWidth(400);


        //myLayout = lab1(myLayout);
        secondLayout = lab2(secondLayout);
        setContentView(secondLayout);

        //setContentView(R.layout.activity_main);
    }
}

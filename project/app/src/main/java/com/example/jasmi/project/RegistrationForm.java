package com.example.jasmi.project;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Jasmine and Rebecka 2019-01-11
 */

public class RegistrationForm extends LinearLayout{

    Context c;
    FormField nameField, emailField, passwordField, dateField;

    //Constructor
    public RegistrationForm(Context context) {
        super(context);
        c = context;
        this.setOrientation(LinearLayout.VERTICAL);
        init();

    }

    //Adds elements to registration-form
    private void init() {
        //Sets padding and layout for objects
        this.setPadding(40,40,40,40);
        LinearLayout.LayoutParams formParam = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        formParam.setMargins(0, 0,0,50);

        LinearLayout.LayoutParams canvasParam = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 180);

        TextView name = new TextView(c);
        name.setText("Name*");
        nameField = new FormField(c, 1);

        this.addView(name);
        this.addView(nameField, formParam);

        TextView email = new TextView(c);
        email.setText("E-mail*");
        emailField = new FormField(c, 2);

        this.addView(email);
        this.addView(emailField, formParam);

        PasswordCheck psCheck = new PasswordCheck(c);
        TextView password = new TextView(c);
        password.setText("Password*");
        passwordField = new FormField(c, 3, psCheck);
        passwordField.setId(100);

        this.addView(password);
        this.addView(passwordField, formParam);
        this.addView(psCheck, canvasParam);

        TextView date = new TextView(c);
        date.setText("Date of Birth");
        dateField = new FormField(c, 4);

        this.addView(date);
        this.addView(dateField, formParam);

        Button submit = new Button(c);
        submit.setText("Sign up");
        submit.setTextColor(Color.WHITE);
        submit.setBackgroundColor(Color.rgb(90, 115, 170));
        //Onclicklistener when user wants to submit form
        submit.setOnClickListener(new OnClickListener() {
            public void onClick(View v)
            {
                if(isFilled())
                    Toast.makeText(c, "Your account is created", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(c, "Fill out all the required fields", Toast.LENGTH_LONG).show();
            }
        });

        this.addView(submit, formParam);


    }

    //Check if all the required fields are filled
    public boolean isFilled(){
        if(nameField.isFilled() && emailField.isFilled() && passwordField.isFilled())
            return true;
        else
            return false;
    }



}

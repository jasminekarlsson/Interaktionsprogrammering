package com.example.jasmi.project;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Jasmine and Rebecka 2019-01-11
 */

public class FormField extends android.support.v7.widget.AppCompatEditText{

    Context c;
    int type; //0 is general field, 1 is Name, 2 is e-mail, 3 is password, 4 is Date of birth
    PasswordCheck pwcheck; //Bar that views how secure the password is
    Boolean filled = false; //Tells if th field is filled out or not


    //Constructor
    public FormField(Context context) {
        super(context);
        c = context;
        type = 0;
        pwcheck = new PasswordCheck(c);
        init();
    }

    //Constructor with specified input type
    public FormField(Context context, int inputType) {
        super(context);
        c = context;
        type = inputType;
        pwcheck = new PasswordCheck(c);
        init();
    }

    //Constructor that adds a password bar that belongs to the field
    public FormField(Context context, int inputType, PasswordCheck check){
        super(context);
        c = context;
        type = inputType;
        pwcheck = check;
        init();
    }


    private void init() {

        this.addTextChangedListener((TextWatcher) changedText);

        //Sets the attributes for the specified type
        switch (type){
        case 0:
            this.setInputType(InputType.TYPE_CLASS_TEXT);
            this.setHint("Write here");
            break;
        case 1:
            this.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
            this.setHint("Ex. Anna");
            break;
        case 2:
            this.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            this.setHint("Ex. Anna@mail.com");
            break;
        case 3:
            this.setTransformationMethod(new PasswordTransformationMethod());
            this.setHint("******");
            break;
        case 4:
            this.setInputType(InputType.TYPE_CLASS_DATETIME);
            this.setHint("Ex. 1991-02-15");
            break;

        default:
            this.setInputType(InputType.TYPE_CLASS_TEXT);
            this.setHint("Write here");
            break;

        }

    }

    private void changeColor(boolean change){
        //Change the color to green if the field is correctly filled in
        if(change)
            this.setBackgroundColor(Color.rgb(235, 250, 235));
        else
            this.setBackgroundColor(Color.WHITE);

    }

    //Checks if specified field is correctly filled
    public boolean isFilled(){
        if(!filled)
            this.setBackgroundColor(Color.rgb(255, 230, 230));

        return filled;
    }

    //Tectwatcher that handles change of every field type
    private TextWatcher changedText = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            switch(type){
                case 0:
                    break;
                case 1:
                    //Okay if the name is longer than 1 char
                    if(charSequence.length() > 1)
                        filled = true;
                    else
                        filled = false;

                    break;
                case 2:
                    //Okay if it has at least 6 char, one '@' and one '.'
                    if(charSequence.length() > 5 && charSequence.toString().contains("@") && charSequence.toString().contains("."))
                        filled = true;

                    else
                        filled = false;
                    break;
                case 3:
                    //Check if the password is good, and change the bar accordingly
                    String password = charSequence.toString();
                    filled = pwcheck.checkPassword(password);
                    break;
                case 4:
                    //Okay if the sequence has 10 char. Future work to check if the dates are correct
                    if(charSequence.length() == 10)
                        filled = true;
                    else
                        filled = false;

                    break;
                default:
                    break;

            }
            changeColor(filled);


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}

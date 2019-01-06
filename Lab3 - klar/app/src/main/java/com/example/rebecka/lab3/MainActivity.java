package com.example.rebecka.lab3;

/*
//Old main
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        InteractiveSearcher view = new InteractiveSearcher(this);

        setContentView(view);
    }
}*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout layout;
    EditText editText;
    InteractiveSearcher interactiveSearcher;
    boolean alreadySet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new RelativeLayout(this);
        setContentView(layout);

        editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setHint("Number of names to show");
        editText.setId(1);

        layout.addView(editText);
        editText.addTextChangedListener((TextWatcher) changedText);

    }

    //Function to change the max number of names to display
    private void changeNrOfNames(int nrOfNames){
        if(alreadySet){
            layout.removeView(interactiveSearcher);
        }

        //Field for input of names
        interactiveSearcher = new InteractiveSearcher(this, nrOfNames);

        RelativeLayout.LayoutParams searchParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        searchParams.addRule(RelativeLayout.BELOW, editText.getId());
        layout.addView(interactiveSearcher, searchParams);
    }

    private TextWatcher changedText = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        public void afterTextChanged(Editable s) {
            if(s.length() > 0){
                int nr = Integer.valueOf(s.toString());
                changeNrOfNames(nr);
                alreadySet = true;
            }
        }
    };
}


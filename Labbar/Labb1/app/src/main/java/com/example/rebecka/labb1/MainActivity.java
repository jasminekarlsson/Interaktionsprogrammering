package com.example.rebecka.labb1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongConstant")

    protected LinearLayout lab1(LinearLayout myLayout){
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

    protected GridLayout lab2(GridLayout myLayout){

        myLayout.setColumnCount(2);
        myLayout.setRowCount(4);

        EditText nameField = new EditText(this);
        nameField.setMaxLines(1);
        nameField.setWidth(myLayout.getWidth());
        nameField.setText("Anders");

        EditText passField = new EditText(this);
        passField.setMaxLines(1);
        passField.setText("password");
        passField.setTransformationMethod(PasswordTransformationMethod.getInstance());

        EditText emailField = new EditText(this);
        emailField.setMaxLines(1);
        emailField.setText("Anders.froberg@liu.se");

        TextView name = new TextView(this);
        name.setText("Namn");
        name.setTextSize(16);

        TextView password = new TextView(this);
        password.setText("Lösenord");
        password.setTextSize(16);

        TextView email = new TextView(this);
        email.setText("Epost");
        email.setTextSize(16);

        TextView age = new TextView(this);
        age.setText("Ålder");
        age.setTextSize(16);

        SeekBar ageBar = new SeekBar(this);

        GridLayout.LayoutParams firstCol = new GridLayout.LayoutParams(
                GridLayout.spec(0, GridLayout.CENTER),
                GridLayout.spec(0, GridLayout.LEFT));
        firstCol.setMargins(0,0,120,0);

        myLayout.addView(name,firstCol);


        myLayout.addView(nameField, new GridLayout.LayoutParams(
                GridLayout.spec(0, GridLayout.LEFT),
                GridLayout.spec(1, GridLayout.FILL)));

        myLayout.addView(password, new GridLayout.LayoutParams(
                GridLayout.spec(1, GridLayout.CENTER),
                GridLayout.spec(0, GridLayout.LEFT)));

        myLayout.addView(passField, new GridLayout.LayoutParams(
                GridLayout.spec(1, GridLayout.LEFT),
                GridLayout.spec(1, GridLayout.FILL)));

        myLayout.addView(email, new GridLayout.LayoutParams(
                GridLayout.spec(2, GridLayout.CENTER),
                GridLayout.spec(0, GridLayout.LEFT)));

        myLayout.addView(emailField, new GridLayout.LayoutParams(
                GridLayout.spec(2, GridLayout.LEFT),
                GridLayout.spec(1, GridLayout.FILL)));

        myLayout.addView(age, new GridLayout.LayoutParams(
                GridLayout.spec(3, GridLayout.LEFT),
                GridLayout.spec(0, GridLayout.LEFT)));

        GridLayout.LayoutParams ageParam = new GridLayout.LayoutParams(
                GridLayout.spec(3, GridLayout.LEFT),
                GridLayout.spec(1, GridLayout.FILL));
        ageParam.setMargins(0, 30, 0, 0);

        myLayout.addView(ageBar, ageParam);

        return myLayout;

    }

    protected RelativeLayout lab3(RelativeLayout myLayout) {

        TextView text1 = new TextView(this);
        text1.setText("Hur trivs du på LiU?");
        text1.setId(1);
        TextView text2 = new TextView(this);
        text2.setText("Läser du på LiTH?");
        text2.setId(2);
        TextView text3 = new TextView(this);
        text3.setText("Är detta LiUs logga?");
        text3.setId(3);

        CheckBox ans11 = new CheckBox(this);
        ans11.setText("Bra");
        ans11.setId(11);
        CheckBox ans12 = new CheckBox(this);
        ans12.setText("Mycket bra");
        ans12.setId(12);
        CheckBox ans13 = new CheckBox(this);
        ans13.setText("Jättebra");
        ans13.setId(13);

        CheckBox ans21 = new CheckBox(this);
        ans21.setText("Ja");
        ans21.setId(21);
        CheckBox ans22 = new CheckBox(this);
        ans22.setText("Nej");
        ans22.setId(22);

        CheckBox ans31 = new CheckBox(this);
        ans31.setText("Ja");
        ans31.setId(31);
        CheckBox ans32 = new CheckBox(this);
        ans32.setText("Nej");
        ans32.setId(32);

        ImageView image = new ImageView(this);
        image.setId(4);
        image.setImageResource(R.drawable.liu_logga);

        Button myButton = new Button(this);
        myButton.setId(5);
        myButton.setText("Skicka in");

        RelativeLayout.LayoutParams q1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a11 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a12 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a13 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams q2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a21 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a22 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams q3 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a31 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams a32 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        q1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        q1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        a11.addRule(RelativeLayout.BELOW, text1.getId());
        //a12.addRule(RelativeLayout.ALIGN_BASELINE, ans11.getId());
        a12.addRule(RelativeLayout.ALIGN_BOTTOM, ans11.getId());
        a12.addRule(RelativeLayout.END_OF, ans11.getId());
        a13.addRule(RelativeLayout.ALIGN_BASELINE, ans12.getId());
        a13.addRule(RelativeLayout.ALIGN_BOTTOM, ans12.getId());
        a13.addRule(RelativeLayout.END_OF, ans12.getId());

        q2.addRule(RelativeLayout.BELOW, ans11.getId());
        q2.addRule(RelativeLayout.CENTER_HORIZONTAL);
        a21.addRule(RelativeLayout.BELOW, text2.getId());
        a21.addRule(RelativeLayout.ALIGN_PARENT_START);
        //a22.addRule(RelativeLayout.ALIGN_BASELINE, ans21.getId());
        a22.addRule(RelativeLayout.ALIGN_BOTTOM, ans21.getId());
        a22.addRule(RelativeLayout.END_OF, ans21.getId());

        q3.addRule(RelativeLayout.BELOW, image.getId());
        q3.addRule(RelativeLayout.CENTER_HORIZONTAL);
        a31.addRule(RelativeLayout.BELOW, text3.getId());
        a31.addRule(RelativeLayout.ALIGN_PARENT_START);
        a32.addRule(RelativeLayout.ALIGN_BASELINE, ans31.getId());
        a32.addRule(RelativeLayout.ALIGN_BOTTOM, ans31.getId());
        a32.addRule(RelativeLayout.END_OF, ans31.getId());

        imageParams.addRule(RelativeLayout.BELOW, ans21.getId());
        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        buttonParams.addRule(RelativeLayout.BELOW, ans31.getId());
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);


        myLayout.addView(text1, q1);
        myLayout.addView(ans11, a11);
        myLayout.addView(ans12, a12);
        myLayout.addView(ans13, a13);

        myLayout.addView(text2, q2);
        myLayout.addView(ans21, a21);
        myLayout.addView(ans22, a22);

        myLayout.addView(text3, q3);
        myLayout.addView(ans31, a31);
        myLayout.addView(ans32, a32);

        myLayout.addView(image, imageParams);

        myLayout.addView(myButton, buttonParams);

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

        RelativeLayout thirdLayout = new RelativeLayout(this);
        thirdLayout.setMinimumWidth(400);


        //myLayout = lab1(myLayout);
        //secondLayout = lab2(secondLayout);
        thirdLayout = lab3(thirdLayout);

        //setContentView(thirdLayout);

        setContentView(R.layout.activity_main);
    }
}

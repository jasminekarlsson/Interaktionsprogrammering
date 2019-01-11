package com.example.jasmi.project;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.max;

/**
 * Jasmine and Rebecka 2019-01-11
 */

public class PasswordCheck extends View{

    Context c;
    int strength;
    Paint p = new Paint();

    //Constructor
    public PasswordCheck(Context context) {
        super(context);
        c = context;
        strength = 0;
    }

    //Draws the initial bar, and the security of the password
    protected void onDraw(Canvas canvas){
        float yval = 40;
        int end = canvas.getWidth() - 40;
        p.setStrokeWidth(80);
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeJoin(Paint.Join.ROUND);

        p.setColor(Color.LTGRAY);
        canvas.drawLine(40,yval, end - 20, yval, p);
        String text = "";
        switch (strength) {
            case 0:
                text = "Password too short";
                break;
            case 1:
                text = "Weak";
                p.setColor(Color.rgb(215, 110, 110));
                break;
            case 2:
                text = "Fair";
                p.setColor(Color.rgb(242,180,35));
                break;
            case 3:
                text = "Good";
                p.setColor(Color.BLUE);
                p.setColor(Color.rgb(125, 185, 220));
                break;
            case 4:
                text = "Excellent";
                //p.setColor(Color.rgb(44, 124, 60));
                p.setColor(Color.rgb(127, 220, 145));
                break;
            default:
                break;

        }
        if(strength > 0)
            canvas.drawLine(40,yval, max(40, end/4*(strength)), yval, p);
        p.setTextSize(45f);
        p.setColor(Color.WHITE);
        canvas.drawText(text, 60, 55, p);

    }

    //Check the strength of password
    public Boolean checkPassword(String password){
        strength = 0;

        //Check if password contains at least 8 letters
        if(password.length() >= 8) {
            strength += 1;
            boolean upperC = false, lowerC = false, number = false;

            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i)))
                    upperC = true;

                if (Character.isLowerCase(password.charAt(i)))
                    lowerC = true;

                if (Character.isDigit(password.charAt(i)))
                    number = true;
            }

            //Check if password contains both uppercase and lowercase letter
            if (upperC && lowerC)
                strength += 1;
            //Check if password contains a number
            if (number)
                strength += 1;

            //Check if the password contains special characters
            if (!password.matches("[a-zA-Z0-9]*")) {
                System.out.println("string '"+ password + "' contains special character");
                strength += 1;
            }


        }

        //Redraw bar - force UI to update
        invalidate();
        if (strength >= 2)
            return true;
        else
            return false;
    }

}

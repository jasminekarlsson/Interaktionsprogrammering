package com.example.jasmi.lab3;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jasmi.lab3.InteractiveSearcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        InteractiveSearcher view = new InteractiveSearcher(this);

        setContentView(view);

    }
}

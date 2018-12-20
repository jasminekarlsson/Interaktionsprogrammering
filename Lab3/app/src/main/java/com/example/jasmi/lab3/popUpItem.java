package com.example.jasmi.lab3;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by jasmi on 2018-12-18.
 */

public class popUpItem extends View {

    String name;

    public popUpItem(Context context, String n) {
        super(context);
        name = n;
    }

    @Override
    protected void onDraw(Canvas canvas){

    }

    @Override
    protected void onMeasure(int width, int height){

    }

}

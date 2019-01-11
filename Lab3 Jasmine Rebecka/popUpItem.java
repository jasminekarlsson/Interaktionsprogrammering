package com.example.jasmi.lab3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jasmi on 2018-12-18.
 */

public class popUpItem extends View {

    Context context;
    String nameItem;
    Paint paint = new Paint();

    public popUpItem(Context c, String name){
        super(c);
        context = c;
        nameItem = name;
    }

    public popUpItem(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint.setColor(Color.LTGRAY);
        paint.setTextSize(45f);

        canvas.drawText(nameItem, 0, paint.getTextSize(), paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(w, 50);
    }


}

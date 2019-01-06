package com.example.rebecka.lab3;

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
    String resultItem;
    Paint paint = new Paint();

    public popUpItem(Context context, String resultItem){
        super(context);
        this.context = context;
        this.resultItem = resultItem;
    }

    public popUpItem(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        paint.setTextSize(40f);

        canvas.drawText(resultItem, 0, paint.getTextSize(), paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(w, 50);
    }
}
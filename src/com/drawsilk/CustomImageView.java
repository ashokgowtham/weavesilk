package com.drawsilk;

import android.*;
import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomImageView extends View implements View.OnTouchListener{

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    int rgb(int r, int g, int b){
        r = r & 0xff;
        g = g & 0xff;
        b = b & 0xff;

        return  0xff << 24 |
                r << 16 |
                g << 8 |
                b;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(rgb(34,67,90));

        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(rgb(0, 255, 0));

        float cX,cY;
        float r;

        int N = 200;

        cX=200;
        cY=200;

        r=50;

        for (int i=0;i<N;i++){
            paint.setColor(rgb(i,0,0));

            canvas.drawLine(
                    cX,cY,
                    (int)(cX + r * Math.sin(i/255.0*2*Math.PI)),
                    (int)(cY + r * Math.cos(i/255.0*2*Math.PI)),
                    paint);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //draw something based on touch

        return super.onTouchEvent(motionEvent);
    }
}

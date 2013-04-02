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

    int rgb(double r, double g, double b){
        int r1=(int)(r*255);
        int g1=(int)(g*255);
        int b1=(int)(b*255);
        r1 = r1 & 0xff;
        g1 = g1 & 0xff;
        b1 = b1 & 0xff;

        return  0xff << 24 |
                r1 << 16 |
                g1 << 8 |
                b1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(rgb(34,67,90));

        //New Code:

        Painter painter = new Painter(canvas);
        painter.Draw();


//Retaining old code for reference

        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(rgb(0, 255, 0));

        float cX,cY;
        float r;

        float N = 20;

        cX=200;
        cY=200;

        r=50;

        for (int i=0;i<N;i++){
            float normalizedValue = i / N;
            paint.setColor(rgb(normalizedValue, 0, 0));

            canvas.drawLine(
                    cX,cY,
                    (int)(cX + r * Math.sin(normalizedValue *2*Math.PI)),
                    (int)(cY + r * Math.cos(normalizedValue *2*Math.PI)),
                    paint);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //draw something based on touch

        //however actual 'drawing' is not done here.
        //this should only run the calculation logic.
        //this invalidates the view - which will in turn get redrawn.
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
         }

        invalidate();

        return super.onTouchEvent(motionEvent);
    }
}

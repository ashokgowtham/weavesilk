package com.drawsilk;

import android.*;
import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomImageView extends View{

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

        for (int i=0;i<255;i++){
            paint.setColor(rgb(i,0,0));
            canvas.drawLine(
                    200,200,
                    (int)(200+400*Math.sin(i/255.0*2*Math.PI)),
                    (int)(200+400*Math.cos(i/255.0*2*Math.PI)),
                    paint);
        }
    }
}

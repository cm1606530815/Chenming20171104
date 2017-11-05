package com.qizu.chenming20171104;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/**
 * Created by jiuhao on 2017/11/04.
 * data 2017/11/04
 * time 上午 08:04
 */
public class CircleProgress extends View{
    Paint mPaint;
    int radioWidth = 30 ;
    int progress = 0 ;
    int max = 360;
    public CircleProgress(Context context) {
        super(context);
    }
    public CircleProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(progress > 360){
                        return;
                    }
                    postInvalidate();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress += 10;


                }

            }
        }).start();
    }

    public CircleProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth() / 2 ;

        int radius = center - radioWidth ;

        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);


        canvas.drawCircle(center,center,radius,mPaint);

        mPaint.setStrokeWidth(8);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(center-radius,center-radius,center+radius,center+radius);

        System.out.println("progress = " + progress);
        canvas.drawArc(rectF,-90,progress,false,mPaint);


        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        int percent = progress;  //中间的进度百分比，先转换成float在进行除法运算，不然都为0
        float textWidth = mPaint.measureText(percent+"  %   ");
        mPaint.setTextSize(20);
        canvas.drawText((float)progress/(float) 360 * 100 +"%",center-radioWidth,center,mPaint);

    }
}

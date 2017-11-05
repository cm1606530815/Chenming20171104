package com.qizu.chenming20171104;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jiuhao on 2017/11/04.
 * data 2017/11/04
 * time 上午 09:27
 */

public class JucingView extends View{
    Paint mPaint;
    ShapeDrawable sd1;
    ShapeDrawable sd2;
    ShapeDrawable sd3;
    public JucingView(Context context) {
        super(context);
    }

    public JucingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public JucingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Shader mShader = new LinearGradient(0,0,100,100, new int[]{
//                Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW
//        },null,Shader.TileMode.REPEAT);
        mPaint.setColor(Color.GRAY);



//画一个实心正方形

        sd1 = new ShapeDrawable(new RectShape());
        sd2 = new ShapeDrawable(new RectShape());
        sd3 = new ShapeDrawable(new RectShape());
//        sd1.setColorFilter(Color.GREEN,null);
//        sd2.setColorFilter(Color.BLUE,null);
//        sd3.setColorFilter(Color.RED,null);
        sd1.setBounds(20,130,60,170);
        sd2.setBounds(60,170,100,210);
        sd3.setBounds(100,210,140,250);
        sd1.draw(canvas);
        sd2.draw(canvas);
        sd3.draw(canvas);

    }
}

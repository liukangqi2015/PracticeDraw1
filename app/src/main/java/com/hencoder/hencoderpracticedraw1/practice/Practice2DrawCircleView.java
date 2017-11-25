package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private Paint paint4;

    public Practice2DrawCircleView(Context context) {
        super(context);
        initPaint();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint(){
        paint1=new Paint();
        paint1.setAntiAlias(true);
        paint1.setColor(Color.BLACK);
        paint2=new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(Color.BLACK);
        paint2.setStrokeWidth(2);
        paint3=new Paint();
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(Color.BLUE);
        paint4=new Paint();
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setColor(Color.BLACK);
        paint4.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        //画实心圆
        canvas.drawCircle(200,200,150,paint1);
        //画空心圆
        canvas.drawCircle(600,200,150,paint2);
        //画蓝色实心圆
        canvas.drawCircle(200,600,150,paint3);
        //画线宽为20的空心圆
        canvas.drawCircle(600,600,150,paint4);
    }
}

package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {
    //绘制坐标系的画笔
    private Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    //绘制直方图内容的画图
    private Paint rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    //纵坐标的高度
    private int height = 500;
    //横坐标的宽度
    private int width;
    //坐标偏移原点
    private Point offsetPoint = new Point(100, 100);
    private final int PADDING = 20;//间隔
    private final int WIDTH_ITEM = 100;//宽度
    private int[] heights = {5, 30, 30, 150, 300, 350, 125};
    private String[] lables = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    private RectF rectF = new RectF();

    public Practice10HistogramView(Context context) {
        super(context);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        linePaint.setColor(Color.WHITE);
        rectPaint.setColor(Color.rgb(104, 185, 48));
        rectPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(22);
        //计算横坐标的宽度
        int size = lables.length;
        width = size * WIDTH_ITEM + (size + 1) * PADDING;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        //绘制纵坐标
        canvas.drawLine(offsetPoint.x, offsetPoint.y, offsetPoint.x, offsetPoint.y + height, linePaint);
        //绘制横坐标
        canvas.drawLine(offsetPoint.x, offsetPoint.y + height, offsetPoint.x + width, offsetPoint.y + height, linePaint);
        int lastLeft = offsetPoint.x + PADDING;
        //绘制直方图内容
        for (int i = 0; i < lables.length; i++) {
            rectF.set(lastLeft, offsetPoint.y + height - heights[i], lastLeft + WIDTH_ITEM, offsetPoint.y + height);
            canvas.drawRect(rectF, rectPaint);
            canvas.drawText(lables[i],lastLeft+(WIDTH_ITEM-textPaint.measureText(lables[i]))/2,offsetPoint.y+height+30,textPaint);
            lastLeft = lastLeft + WIDTH_ITEM + PADDING;
        }
    }
}

package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.PieData;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {
    private List<PieData> datas;
    private float total;
    private RectF rectF;
    //开始的角度
    private float startAngle;
    //扫过的角度
    private float sweepAngle;
    // 当前扇形一般的角度;
    private float lineAngle;
    //饼图的半径
    private float radius;
    float lineStartX = 0f; // 直线开始的X坐标
    float lineStartY = 0f; // 直线开始的Y坐标
    float lineEndX;        // 直线结束的X坐标
    float lineEndY;        // 直线结束的Y坐标

    //画扇形的画笔
    private Paint arcPaint;
    //画线的画笔
    private Paint linePaint;
    //绘制文字的画笔
    private Paint textPaint;

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initData();
        rectF = new RectF(-300, -300, 300, 300);
        radius = rectF.right;
        arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arcPaint.setStyle(Paint.Style.FILL);
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.WHITE);
        textPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(18);
    }

    private void initData() {
        datas = new ArrayList<>();
        PieData data01 = new PieData("Gingerbread", 10.0f, Color.rgb(166, 28, 175));
        datas.add(data01);
        PieData data02 = new PieData("Ice Cream Sandwich", 18.0f, Color.rgb(176, 190, 197));
        datas.add(data02);
        PieData data03 = new PieData("Jelly Bean", 22.0f, Color.rgb(2, 150, 136));
        datas.add(data03);
        PieData data04 = new PieData("KitKat", 27.0f, Color.rgb(0, 149, 239));
        datas.add(data04);
        PieData data05 = new PieData("Lollipop", 40.0f, Color.rgb(255, 68, 61));
        datas.add(data05);
        PieData data06 = new PieData("Marshmallow", 60.0f, Color.rgb(255, 194, 54));
        datas.add(data06);
        PieData data07 = new PieData("Nougat", 33.5f, Color.rgb(240, 98, 146));
        datas.add(data07);
        for (PieData pieData : datas) {
            total = total + pieData.getPercent();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
        if (datas != null && datas.size() > 0) {
            for (PieData data : datas) {
                sweepAngle = data.getPercent() / total * 360f;
                //计算画线的起点，即每个扇形的弧中心点
                lineAngle=startAngle+sweepAngle/2;
                lineStartX= (float) (radius*Math.cos(lineAngle/180f*Math.PI));
                lineStartY= (float) (radius*Math.sin(lineAngle/180*Math.PI));
                //计算画线的终点
                lineEndX = (radius + 30) * (float) Math.cos(lineAngle / 180 * Math.PI);
                lineEndY = (radius + 30) * (float) Math.sin(lineAngle / 180 * Math.PI);
                arcPaint.setColor(data.getColor());
                //画扇形
                canvas.drawArc(rectF, startAngle, sweepAngle, true, arcPaint);
                canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, linePaint);
                if (lineAngle>90f&&lineAngle<=270f){
                    //当线的角度>90度和<270度时，线要往左偏，绘制文字时要减去字的宽度
                    canvas.drawLine(lineEndX,lineEndY,lineEndX-50,lineEndY,linePaint);
                    canvas.drawText(data.getName(),lineEndX-50-textPaint.measureText(data.getName())-10,lineEndY,textPaint);
                }else {
                    canvas.drawLine(lineEndX,lineEndY,lineEndX+50,lineEndY,linePaint);
                    canvas.drawText(data.getName(),lineEndX+50+10,lineEndY,textPaint);
                }
                startAngle = startAngle + sweepAngle;
            }
        }

    }
}

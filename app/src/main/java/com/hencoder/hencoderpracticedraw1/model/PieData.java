package com.hencoder.hencoderpracticedraw1.model;

/**
 * Created by Gray on 2017/11/27.
 *
 */

public class PieData {
    private String name;
    private float percent;
    private int color;

    public PieData(String name, float percent, int color) {
        this.name = name;
        this.percent = percent;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

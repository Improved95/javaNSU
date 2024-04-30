package org.lab3.slashBlade;

import java.awt.*;

public class FrameSize {
    public final int widthRes = 16;
    public final int heightRes = 9;
    private double reductionFactor;
    private int width;
    private int height;
    private Insets insets;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        reductionFactor = width / (double)1920;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getReductionFactor() {
        return reductionFactor;
    }

    public Insets getInsets() {
        return insets;
    }

    public void setInsets(Insets insets) {
        this.insets = insets;
    }
}
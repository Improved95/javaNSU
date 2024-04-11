package org.lab4.jframe;

import javax.swing.*;

public class Slider extends JSlider {
    public Slider(int height, int minValue, int maxValue) {
        this.setMinimum(minValue);
        this.setMaximum(maxValue);

        this.setOrientation(JSlider.VERTICAL);
        this.setSize(60, 400);
        this.setValue(0);

        this.setPaintTicks(true);
        this.setPaintLabels(true);

        this.setMajorTickSpacing(100);
//        this.setMinorTickSpacing(50);

        this.setVisible(true);
    }
}
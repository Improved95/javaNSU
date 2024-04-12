package org.lab4.jframe;

import javax.swing.*;
import java.awt.*;

public class SliderLabel extends JLabel {
    private int posX;
    private int posY;
    private int height;
    private int labelWidth = 60;

    public SliderLabel(int posX, int posY, int height, int minValue, int maxValue) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;

        this.add(new slider(height, minValue, maxValue));

        this.setBounds(posX, posY - 40, labelWidth, height);
        this.setVisible(true);
    }

    class slider extends JSlider {
        public slider(int height, int minValue, int maxValue) {
            this.setMinimum(minValue);
            this.setMaximum(maxValue);

            this.setOrientation(JSlider.VERTICAL);
            this.setSize(labelWidth, height);
            this.setValue(0);

            this.setPaintTicks(true);
            this.setPaintLabels(true);

            this.setMajorTickSpacing(maxValue / 8);
//        this.setMinorTickSpacing(50);

            this.setVisible(true);
        }
    }
}

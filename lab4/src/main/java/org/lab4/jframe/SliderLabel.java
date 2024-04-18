package org.lab4.jframe;

import javax.swing.*;
import java.awt.*;

public class SliderLabel extends JPanel {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int minValue;
    private int maxValue;

    public SliderLabel(int posX, int posY, int width, int height, int minValue, int maxValue, String sliderDesc) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.minValue = minValue;
        this.maxValue = maxValue;

        setLayout(null);
        setBounds(posX, posY, width + 100, height);

        addText(sliderDesc);
//        addSlider();

        setVisible(true);
    }

    private void addText(String sliderDesc) {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBounds(posX, posY, 150, height);

        JLabel text = new JLabel();
        text.setText(sliderDesc);
        text.setVerticalAlignment(JLabel.TOP);
        text.setHorizontalAlignment(JLabel.LEFT);

        textPanel.add(text);

        add(textPanel);
    }

    private void addSlider() {
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BorderLayout());
        sliderPanel.setBounds(posX + 100, posY, width, height);

        JSlider slider = new JSlider();
        slider.setMinimum(minValue);
        slider.setMaximum(maxValue);

        slider.setOrientation(JSlider.HORIZONTAL);
        slider.setSize(width, height);
        slider.setValue(maxValue);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setMajorTickSpacing(maxValue / 4);
//        setMinorTickSpacing(50);

        sliderPanel.add(slider);

        add(sliderPanel);
    }

}

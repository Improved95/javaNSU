package org.lab4.jframe;

import javax.swing.*;

public class SliderLabel extends JPanel {
    private int width;
    private int height;
    private int minValue;
    private int maxValue;

    private int textWidth = 160;

    public SliderLabel(int posX, int posY, int width, int height, int minValue, int maxValue, String sliderDesc) {
        this.width = width;
        this.height = height;
        this.minValue = minValue;
        this.maxValue = maxValue;

        setBounds(posX, posY, width + textWidth, height);

        setLayout(null);

        addText(sliderDesc);
        addSlider();

        setVisible(true);
    }

    private void addText(String sliderDesc) {
        JLabel text = new JLabel();
        text.setText(sliderDesc);
        text.setVerticalAlignment(JLabel.TOP);
        text.setHorizontalAlignment(JLabel.LEFT);
        text.setBounds(0, 10, textWidth, height);
        text.setOpaque(false);
        add(text);
    }

    private void addSlider() {
        JSlider slider = new JSlider();
        slider.setBounds(textWidth, 0, width, height);

        slider.setMinimum(minValue);
        slider.setMaximum(maxValue);

        slider.setOrientation(JSlider.HORIZONTAL);
        slider.setSize(width, height);
        slider.setValue(maxValue);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setMajorTickSpacing(maxValue / 4);
//        setMinorTickSpacing(50);

        slider.setOpaque(false);

        add(slider);
    }

}

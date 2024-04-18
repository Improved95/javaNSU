package org.lab4.jframe;

import javax.swing.*;
import java.awt.*;

public class SliderLabel extends JLabel {
    private int posX;
    private int posY;
    private int width;
    private int height;

    public SliderLabel(int posX, int posY, int width, int height, int minValue, int maxValue, String sliderDesc) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;

        setLayout(new BorderLayout());
        setBounds(posX, posY, width + 500, height);

        // Создаем метку с текстом
        JLabel text = new JLabel();
        text.setText(sliderDesc);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.TOP);

        add(text, BorderLayout.CENTER);

        setBackground(Color.gray);
        setOpaque(true);
//        add(new slider(height, minValue, maxValue));

        setVisible(true);
    }

    class slider extends JSlider {
        public slider(int height, int minValue, int maxValue) {
            setMinimum(minValue);
            setMaximum(maxValue);

            setOrientation(JSlider.HORIZONTAL);
            setSize(width, height);
            setValue(maxValue);

            setPaintTicks(true);
            setPaintLabels(true);

            setMajorTickSpacing(maxValue / 4);
//        setMinorTickSpacing(50);

            setVisible(true);
        }
    }
}

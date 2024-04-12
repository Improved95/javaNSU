package org.lab4.jframe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JFrameObject {
    private final int frameWidth = 800;
    private final int frameHeight = 500;

    private JFrame frame;
    private List<SliderLabel> scrollBarList = new ArrayList<>();

    public JFrameObject() {
        this.frame = getJFrame();
        setSliders();
        initial();
    }

    private void initial() {
        for (SliderLabel sliderLabel : scrollBarList) {
            frame.add(sliderLabel);
        }

        frame.repaint();
    }

    private void setSliders() {
        int sliderHeight = 350;
        int sliderMinValue = 0;
        int sliderMaxValue = 2000;
        scrollBarList.add(new SliderLabel(frameWidth - 80, frameHeight - sliderHeight, sliderHeight, sliderMinValue, sliderMaxValue));
        scrollBarList.add(new SliderLabel(frameWidth - 320, frameHeight - sliderHeight, sliderHeight, sliderMinValue, sliderMaxValue));
        scrollBarList.add(new SliderLabel(frameWidth - 240, frameHeight - sliderHeight, sliderHeight, sliderMinValue, sliderMaxValue));
        scrollBarList.add(new SliderLabel(frameWidth - 160, frameHeight - sliderHeight, sliderHeight, sliderMinValue, sliderMaxValue));
    }

    private JFrame getJFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - frameWidth / 2, dimension.height / 2 - frameHeight / 2, frameWidth, frameHeight);
        return jFrame;
    }
}

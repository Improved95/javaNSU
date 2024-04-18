package org.lab4.jframe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JFrameObject {
    private final int frameWidth = 800;
    private final int frameHeight = 500;

    private JFrame frame;
    private List<SliderLabel> slidersList = new ArrayList<>();

    public JFrameObject() {
        this.frame = getJFrame();
        setSliders();
        initial();
    }

    private void initial() {
        for (SliderLabel sliderLabel : slidersList) {
            frame.add(sliderLabel);
        }
        frame.repaint();
    }



    private void setSliders() {
        int sliderWidth = 50;
        int sliderHeight = 50;
        slidersList.add(new SliderLabel(20, 20, sliderWidth, sliderHeight, 0, 1000, "Accessory provider speed:"));
//        slidersList.add(new SliderLabel(20, 20, sliderHeight, 0, 2000));
//        slidersList.add(new SliderLabel(20, 20, sliderHeight, 0, 2000));
//        slidersList.add(new SliderLabel(20, 20, sliderHeight, 0, 2000));
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

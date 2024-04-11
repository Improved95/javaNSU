package org.lab4.jframe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JFrameObject {
    private final int frameWidth = 800;
    private final int frameHeight = 500;

    private JFrame frame;
    private List<Slider> scrollBarList = new ArrayList<>();

    public JFrameObject() {
        this.frame = getJFrame();
        setSliders();



        initial();
    }

    private void initial() {
        for (Slider slider : scrollBarList) {
            frame.add(slider);
        }

        frame.repaint();
    }

    private void setSliders() {
        scrollBarList.add(new Slider(400, 0, 1000));
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

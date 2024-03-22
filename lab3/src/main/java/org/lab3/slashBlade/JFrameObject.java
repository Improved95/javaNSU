package org.lab3.slashBlade;

import javax.swing.*;
import java.awt.*;

public class JFrameObject {
    private int width;
    private int height;
    private JFrame jFrame;

    public JFrameObject(int width) {
        this.width = width;
        this.height = getHeightByWidth();
        this.jFrame = getFrame();
    }

    public int getScreenHeight() {
        return height;
    }

    public JFrame getJFrame() {
        return jFrame;
    }

    private class Resolution {
        public static final int widthRes = 16;
        public static final int heightRes = 9;
    }

    private int getHeightByWidth() {
        return (width * Resolution.heightRes) / Resolution.widthRes;
    }

    private JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2, width, height);
        jFrame.setVisible(true);
        return jFrame;
    }
}

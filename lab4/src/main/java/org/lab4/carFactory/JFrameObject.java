package org.lab4.carFactory;

import javax.swing.*;
import java.awt.*;

public class JFrameObject {
    private final int frameWidth = 800;
    private final int frameHeight = 500;

    private JFrame jFrame;

    public JFrameObject() {
        this.jFrame = getJFrame();
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

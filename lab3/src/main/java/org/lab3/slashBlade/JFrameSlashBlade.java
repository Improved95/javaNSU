package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.view.View;

import javax.swing.*;
import java.awt.*;

public class JFrameSlashBlade extends Frame implements JFrameObject {
    private int width;
    private int height;
    private JFrame jFrame;

    public JFrameSlashBlade(int width, Controller slashBlaseController) {
        this.width = width;
        this.height = getHeightByWidth();
        this.jFrame = getFrame();
        this.jFrame.addKeyListener(slashBlaseController);
    }

    public void addDrawableComponent(View slashBladeView) {
        Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                System.out.println("paint");
                Graphics2D g2 = (Graphics2D) g;
                slashBladeView.drawObject(g2, height);
                g2.dispose();
            }
        };
        jFrame.add(canvas);
    }

    @Override
    public void repaintObjects() {
        super.repaint();
    }

    private int getHeightByWidth() {
        return (width * Resolution.heightRes) / Resolution.widthRes;
    }

    private static class Resolution {
        public static final int widthRes = 16;
        public static final int heightRes = 9;
    }

    private JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2, width, height);
        return jFrame;
    }
}

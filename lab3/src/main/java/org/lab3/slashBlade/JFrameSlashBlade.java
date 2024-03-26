package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JFrameSlashBlade implements JFrameObject {
    private int width;
    private int height;
    private JFrame jFrame;
    private Canvas canvas;

    public JFrameSlashBlade(int width) {
        this.width = width;
        this.height = getHeightByWidth();
        this.jFrame = getFrame();
    }

    public void addDrawableComponent(View slashBladeView, Controller controller) {
        canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
                slashBladeView.drawObject(g2, height);
                g2.dispose();
            }
        };
        canvas.addKeyListener(controller);
        jFrame.add(canvas);
    }

    @Override
    public void repaintObjects() {
        canvas.repaint();
    }

    private int getHeightByWidth() {
        return (width * Resolution.heightRes) / Resolution.widthRes;
    }

    private class Resolution {
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

package org.lab3.slashBlade;

import org.lab3.view.SlashBladeView;

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

    public void addDrawableComponent(SlashBladeView slashBladeView) {
        jFrame.add(new MyComponent(slashBladeView, height));
    }

    private static class MyComponent extends JComponent {
        private SlashBladeView slashBladeView;
        private int screenHeight;

        public MyComponent(SlashBladeView slashBladeView, int screenHeight) {
            this.slashBladeView = slashBladeView;
            this.screenHeight = screenHeight;
        }

        @Override
        protected void paintComponent(Graphics g) {
            System.out.println("paintComponent");
            Graphics2D g2 = (Graphics2D)g;

            slashBladeView.drawObject(g2, screenHeight);

            g2.dispose();
        }
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

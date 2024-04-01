package org.lab3.slashBlade;

import org.lab3.controller.keysListener.KeyListenerController;
import org.lab3.view.View;

import javax.swing.*;
import java.awt.*;

public class JFrameSlashBlade extends JFrame implements JFrameObject {
    private FrameSize frameSize = new FrameSize();
    private JFrame jFrame;
    private MyComponent myComponent;

    public JFrameSlashBlade(int width) {
        this.frameSize.setWidth(width);
        this.frameSize.setHeight(getHeightByWidth());
        this.jFrame = getFrame();
    }

    public FrameSize getFrameSize() {
        return frameSize;
    }

    public void addDrawableComponent(View slashBladeView, KeyListenerController keyListenerController) {
        myComponent = new MyComponent(slashBladeView);
        jFrame.addKeyListener(keyListenerController);
        jFrame.addMouseListener(keyListenerController);
        jFrame.add(myComponent);
    }

    private class MyComponent extends JComponent {
        private View view;

        public MyComponent(View view) {
            this.view = view;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            view.drawObject(g2, frameSize);
            g2.dispose();
        }
    }

    @Override
    public void repaintObjects() {
        myComponent.repaint();
    }

    private int getHeightByWidth() {
        return (frameSize.getWidth() * frameSize.heightRes) / frameSize.widthRes;
    }

    private JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - frameSize.getWidth() / 2, dimension.height / 2 - frameSize.getHeight() / 2, frameSize.getWidth(), frameSize.getHeight());
        return jFrame;
    }
}

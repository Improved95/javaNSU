package org.lab3.slashBlade;

import org.lab3.controller.controller.KeyListenerController;
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

    @Override
    public JFrame getJFrame() {
        return jFrame;
    }

    public FrameSize getFrameSize() {
        return frameSize;
    }

    @Override
    public void addDrawableComponent(View view, KeyListenerController keyListenerController) {
        myComponent = new MyComponent(view);
        jFrame.addKeyListener(keyListenerController);
        jFrame.addMouseListener(keyListenerController);
        jFrame.add(myComponent);
    }

    class MyComponent extends JComponent {
        private View view;

        public MyComponent(View view) {
            this.view = view;
        }

        @Override
        protected void paintComponent(Graphics g) {
            view.drawObject(g, frameSize);
            g.dispose();
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

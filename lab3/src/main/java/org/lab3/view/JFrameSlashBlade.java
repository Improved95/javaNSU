package org.lab3.view;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;

import javax.swing.*;
import java.awt.*;

public class JFrameSlashBlade extends JFrame implements JFrameObject {
    private FrameSize frameSize = new FrameSize();
    private JFrame jFrame;
    private GamePanel gamePanel;

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
        jFrame.addKeyListener(keyListenerController);
        jFrame.addMouseListener(keyListenerController);
        this.gamePanel = new GamePanel(view, frameSize);
        jFrame.add(gamePanel);
    }

    @Override
    public void repaintObjects() {
        gamePanel.repaint();
    }

    private int getHeightByWidth() {
        return (frameSize.getWidth() * frameSize.heightRes) / frameSize.widthRes;
    }

    private JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.pack();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - frameSize.getWidth() / 2, dimension.height / 2 - frameSize.getHeight() / 2, frameSize.getWidth(), frameSize.getHeight());
        return jFrame;
    }
}

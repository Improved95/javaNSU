package org.lab3.view.swing;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;
import org.lab3.view.FrameObject;
import org.lab3.view.View;

import javax.swing.*;
import java.awt.*;

public class JFrameSlashBlade extends JFrame implements FrameObject {
    private FrameSize frameSize;
    private JFrame jFrame;
    private GamePanel gamePanel;

    public JFrameSlashBlade() {
//        this.jFrame = getFrame();
    }

    @Override
    public void setFrameSize(FrameSize frameSize) {
        this.frameSize = frameSize;
    }

    @Override
    public void addKeyListeners(View view, KeyListenerController keyListenerController) {
        jFrame.addKeyListener(keyListenerController);
        jFrame.addMouseListener(keyListenerController);
    }

    @Override
    public void repaintObjects() {
        gamePanel.repaint();
    }

    @Override
    public void close() {
        jFrame.dispose();
    }

    private JFrame getFrame(View view) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setResizable(false);
        jFrame.setVisible(true);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - frameSize.getWidth() / 2,
                            dimension.height / 2 - frameSize.getHeight() / 2,
                                frameSize.getWidth(), frameSize.getHeight());

        frameSize.setInsets(jFrame.getInsets());

        this.gamePanel = new GamePanel((SwingView) view, frameSize);
        jFrame.add(gamePanel);

        return jFrame;
    }
}

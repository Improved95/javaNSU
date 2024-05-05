package org.lab3.view.swing;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.slashBlade.FrameSize;

import javax.swing.*;
import java.awt.*;

public class SwingFrame extends JFrame {
    private FrameSize frameSize;
    private JFrame jFrame;
    private GamePanel gamePanel;
    private SwingView view;
    private KeyListenerController keyListenerController;

    public void setView(SwingView view) {
        this.view = view;
    }

    public void setFrameSize(FrameSize frameSize) {
        this.frameSize = frameSize;
    }

    public void addInputListeners(KeyListenerController keyListenerController) {
        this.keyListenerController = keyListenerController;
    }

    public void repaintObjects() {
        gamePanel.repaint();
    }

    public void close() {
        jFrame.dispose();
    }

    public void createSwingFrame() {
        this.jFrame = getFrame();
    }

    private JFrame getFrame() {
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

        this.gamePanel = new GamePanel(view, frameSize);
        jFrame.add(gamePanel);

        jFrame.addKeyListener(keyListenerController);
        jFrame.addMouseListener(keyListenerController);

        return jFrame;
    }
}

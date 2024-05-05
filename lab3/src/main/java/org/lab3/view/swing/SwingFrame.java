package org.lab3.view.swing;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.model.model.Model;
import org.lab3.slashBlade.FrameSize;

import javax.swing.*;
import java.awt.*;

public class SwingFrame extends JFrame {
    private FrameSize frameSize;
    private JFrame jFrame;
    private gamePanel gamePanel;
    private SwingView view;
    private KeyListenerController keyListenerController;

    public SwingFrame() {
        view = new SwingView();
    }

    public SwingView getView() {
        return view;
    }

    public void setFrameSize(FrameSize frameSize) {
        this.frameSize = frameSize;
    }

    public void setModel(Model model) {
        view.setModel(model);
    }

    public void addInputListeners(KeyListenerController keyListenerController) {
        this.keyListenerController = keyListenerController;
    }

    public void setDrawing(boolean isDraw) {
        view.setDrawing(isDraw);
    }

    public void repaint() {
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

        this.gamePanel = new gamePanel(view, frameSize);
        jFrame.add(gamePanel);

        jFrame.addKeyListener(keyListenerController);
        jFrame.addMouseListener(keyListenerController);

        return jFrame;
    }
}

class gamePanel extends JPanel {
    private SwingView view;
    private FrameSize frameSize;

    public gamePanel(SwingView view, FrameSize frameSize) {
        this.view = view;
        this.frameSize = frameSize;
        setPanelSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        view.drawObject(g);
        g.dispose();
    }

    private void setPanelSize() {
        Dimension dimension = new Dimension(frameSize.getWidth(), frameSize.getHeight());
        setPreferredSize(dimension);
    }
}

package org.lab3.slashBlade;

import org.lab3.view.View;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private View view;
    private FrameSize frameSize;

    public GamePanel(View view, FrameSize frameSize) {
        this.view = view;
        this.frameSize = frameSize;
        setPanelSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        view.drawObject(g, frameSize);
        g.dispose();
    }

    private void setPanelSize() {
        Dimension dimension = new Dimension(frameSize.getWidth(), frameSize.getHeight());
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
    }
}

package org.lab3.view;

import org.lab3.slashBlade.FrameSize;
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
        view.drawObject(g);
        g.dispose();
    }

    private void setPanelSize() {
        Dimension dimension = new Dimension(frameSize.getWidth(), frameSize.getHeight());
        setPreferredSize(dimension);
    }
}

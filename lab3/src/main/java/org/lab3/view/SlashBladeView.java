package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.gameMode.GameMode;

import javax.swing.*;
import java.awt.*;
import java.util.AbstractList;

class Resolution {
    public static final int widthRes = 16;
    public static final int heightRes = 9;
}

public class SlashBladeView implements View {
    private int width;
    private int height;
    private JFrame jFrame;

    public SlashBladeView(int width) {
        this.width = width;
        this.height = getHeightByWidth();
        this.jFrame = getFrame();
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

    private int getHeightByWidth() {
        return (width * Resolution.heightRes) / Resolution.widthRes;
    }

    @Override
    public void change(Model slashBladeModel) {
        GameMode gameMode = slashBladeModel.getCurrentGameMode();
        AbstractList<NeedDrawObject> drawObjectsList = gameMode.getNeedDrawObject();



        for (NeedDrawObject drawObject : drawObjectsList) {
            System.out.println(drawObject + " " + drawObject.getPosX() + " " + drawObject.getPosY());

            JComponent jComponent = new JComponent() {
                @Override
                public void paint(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g;
                    g2.drawImage(drawObject.getVisualContext().getImage(), drawObject.getPosX(), drawObject.getPosY(), null);
                }
            };
            jFrame.add(jComponent);
        }
    }
}

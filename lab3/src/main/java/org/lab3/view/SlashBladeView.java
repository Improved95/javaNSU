package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.gameMode.GameMode;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.AbstractList;
import java.util.Set;

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

    @Override
    public void change(Model slashBladeModel) throws IllegalAccessException {
        GameMode gameMode = slashBladeModel.getCurrentGameMode();
        Set<NeedDrawObject> drawObjectsList = gameMode.getDrawObjectsList();
        jFrame.add(new MyComponent(drawObjectsList, height));
    }

    private static class MyComponent extends JComponent {
        private Set<NeedDrawObject> drawObjectsList;
        private int screenHeight;

        public MyComponent(Set<NeedDrawObject> drawObjectsList, int screenHeight) {
            this.drawObjectsList = drawObjectsList;
            this.screenHeight = screenHeight;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            for (NeedDrawObject drawObject : drawObjectsList) {
                EditedImage imageEditor = new EditedImage(drawObject);
                imageEditor.resizingImage();
                imageEditor.replaceImage(screenHeight);
                g2.drawImage(imageEditor.getNewImage(), imageEditor.getNewPosX(), imageEditor.getNewPosY(), null);
            }
        }
    }

    private int getHeightByWidth() {
        return (width * Resolution.heightRes) / Resolution.widthRes;
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

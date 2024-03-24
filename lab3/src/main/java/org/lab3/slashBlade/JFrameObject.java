package org.lab3.slashBlade;

import org.lab3.model.NeedDrawObject;
import org.lab3.view.EditedImage;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Set;

public class JFrameObject {
    private int width;
    private int height;
    private JFrame jFrame;

    public JFrameObject(int width) {
        this.width = width;
        this.height = getHeightByWidth();
        this.jFrame = getFrame();
    }

    public void addObjectsOnFrame(Set<NeedDrawObject> drawObjectsList) {
        System.out.println("addObjectsOnFrame");
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
            System.out.println("paintComponent");
            Graphics2D g2 = (Graphics2D)g;
            g2.drawRect(20, 20, 40, 40);
//            for (NeedDrawObject drawObject : drawObjectsList) {
//                EditedImage imageEditor = new EditedImage(drawObject, screenHeight);
//                g2.drawImage(imageEditor.getNewImage(), imageEditor.getNewPosX(), imageEditor.getNewPosY(), null);
//            }
        }
    }

    private int getHeightByWidth() {
        return (width * Resolution.heightRes) / Resolution.widthRes;
    }

    private static class Resolution {
        public static final int widthRes = 16;
        public static final int heightRes = 9;
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

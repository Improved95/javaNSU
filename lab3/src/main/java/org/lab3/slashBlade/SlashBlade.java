package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.controller.SlashBladeController;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

import javax.swing.*;
import java.awt.*;

public class SlashBlade {
    private JFrameObject jFrameObject;

    public void initial() {
        this.jFrameObject = new JFrameObject(1920);
        Controller slashBladeController = null;
        Model slashBladeModel = null;
        View slashBladeView = null;

        try {
            slashBladeController = new SlashBladeController();
            slashBladeModel = new SlashBladeModel();
            slashBladeView = new SlashBladeView();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException ex) {
            ex.printStackTrace();
        }

        try {
            while (true) {
                slashBladeController.readInput();
                slashBladeModel.changeModel(slashBladeController);
                slashBladeView.change(slashBladeModel, jFrameObject);
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}

class JFrameObject {
    private int width;
    private int height;
    private JFrame jFrame;

    public JFrameObject(int width) {
        this.width = width;
        this.height = getHeightByWidth();
        this.jFrame = getFrame();
    }

    public int getHeight() {
        return height;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    private class Resolution {
        public static final int widthRes = 16;
        public static final int heightRes = 9;
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

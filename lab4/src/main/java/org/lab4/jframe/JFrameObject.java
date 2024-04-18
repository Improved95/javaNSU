package org.lab4.jframe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JFrameObject {
    private final int frameWidth = 600;
    private final int frameHeight = 500;

    private JFrame frame;
    private List<SliderLabel> slidersList;
    private List<InfoField> infoFieldList;

    public JFrameObject() {
        this.frame = getJFrame();
        this.slidersList = setSliders();
        this.infoFieldList = setInfoFields();
        initial();
    }

    private void initial() {
        for (SliderLabel sliderLabel : slidersList) {
            frame.add(sliderLabel);
        }
        for (InfoField infoField : infoFieldList) {
            frame.add(infoField);
        }
        frame.repaint();
    }

    private List<SliderLabel> setSliders() {
        int sliderWidth = 300;
        int sliderHeight = 50;
        int posX = 20;
        int posY = 20;
        List<SliderLabel> slidersList = new ArrayList<>();

        String[] slidersText = {
                "CarBody provider delay:",
                "Engine provider delay:",
                "Accessory provider delay:",
                "Dealers request delay:"
        };

        for (int i = 0; i < 4; i++) {
            slidersList.add(new SliderLabel(posX, posY + sliderHeight * i, sliderWidth, sliderHeight, 0, 1000, slidersText[i]));
        }

        return slidersList;
    }

    private List<InfoField> setInfoFields() {
        int infoFieldWidth = 300;
        int infoFieldHeight = 30;
        int posX = 20;
        int posY = 20 + 50 * 4 + 30;
        List<InfoField> infoFieldList = new ArrayList<>();

        String[] fieldsText = {
                "Detail number on CarBody warehouse: ",
                "Waiting detail number on CarBody warehouse: ",
                "Detail number on Engine warehouse: ",
                "Waiting detail number on Engine warehouse: ",
                "Detail number on Accessory warehouse: ",
                "Waiting detail number on Accessory warehouse: ",
                "Ready car number: ",
                "Car number on Cars warehouse: ",
        };

        for (int i = 0; i < 8; i++) {
            infoFieldList.add(new InfoField(posX, posY + infoFieldHeight * i, infoFieldWidth, infoFieldHeight, fieldsText[i]));
        }

        return infoFieldList;
    }

    private JFrame getJFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - frameWidth / 2, dimension.height / 2 - frameHeight / 2, frameWidth, frameHeight);
        jFrame.setLayout(null);
        return jFrame;
    }
}

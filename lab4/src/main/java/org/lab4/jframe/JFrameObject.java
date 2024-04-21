package org.lab4.jframe;

import org.lab4.model.factory.FactoryModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JFrameObject {
    private final int frameWidth = 600;
    private final int frameHeight = 530;

    private JFrame frame;
    private List<SliderLabel> slidersList;
    private List<InfoField> infoFieldList;

    public JFrameObject() {
        this.frame = getJFrame();
        this.slidersList = setSliders();
        this.infoFieldList = setInfoFields();
        initial();
    }

    public JFrame getFrame() {
        return frame;
    }

    public int getCarBodyProviderDelay() {
        return slidersList.get(0).getSliderValue();
    }
    public int getEngineProviderDelay() {
        return slidersList.get(1).getSliderValue();
    }
    public int getAccessoryProviderDelay() {
        return slidersList.get(2).getSliderValue();
    }
    public int getDealersRequestDelay() {
        return slidersList.get(3).getSliderValue();
    }

    public synchronized void setCarBodyWarehouseSize(int value) {
        infoFieldList.get(0).updateValue(value);
        frame.repaint();
    }

    public synchronized void setCarBodyProviderTotalImportedDetailsNumber(int value) {
        infoFieldList.get(1).updateValue(value);
        frame.repaint();
    }

    public synchronized void setEngineWarehouseSize(int value) {
        infoFieldList.get(2).updateValue(value);
        frame.repaint();
    }

    public synchronized void setEngineProviderTotalImportedDetailsNumber(int value) {
        infoFieldList.get(3).updateValue(value);
        frame.repaint();
    }

    public synchronized void setAccessoryWarehouseSize(int value) {
        infoFieldList.get(4).updateValue(value);
        frame.repaint();
    }

    public synchronized void setAccessoryProviderTotalImportedDetailsNumber(int value) {
        infoFieldList.get(5).updateValue(value);
        frame.repaint();
    }

    public synchronized void setReadyCarWarehouseSize(int value) {
        infoFieldList.get(6).updateValue(value);
        frame.repaint();
    }

    public synchronized void setTotalReadyCarCreatedNumber(int value) {
        infoFieldList.get(7).updateValue(value);
        frame.repaint();
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
        int infoFieldWidth = 350;
        int infoFieldHeight = 30;
        int posX = 20;
        int posY = 20 + 50 * 4 + 30;
        List<InfoField> infoFieldList = new ArrayList<>();

        String[] fieldsText = {
                "Detail number on CarBody warehouse: ",
                "Total CarBody imported number: ",
                "Detail number on Engine warehouse: ",
                "Total Engine imported number: ",
                "Detail number on Accessory warehouse: ",
                "Total Accessory imported number: ",
                "Detail number on ReadyCar warehouse: ",
                "Total ReadyCar created number: ",
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

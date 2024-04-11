package org.lab4.controller.factory;

import org.lab4.jframe.JFrameObject;
import org.lab4.model.FactoryModel;

import java.io.IOException;
import java.io.InputStream;

public class FactoryWorkflow {
    private JFrameObject jFrameObject;
    private FactoryModel factoryModel = new FactoryModel();

    public FactoryWorkflow() {
        initial();
    }

    public void execute() {

    }

    private void initial() {
        jFrameObject = new JFrameObject();

        try (InputStream config = this.getClass().getResourceAsStream("../../../../config")) {
            factoryModel.setFactoryConfig(ConfigParser.parse(config));
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}

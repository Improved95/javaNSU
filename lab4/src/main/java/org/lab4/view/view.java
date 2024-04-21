package org.lab4.view;

import org.lab4.jframe.JFrameObject;
import org.lab4.model.factory.FactoryModel;

import static java.lang.Thread.sleep;

public class view implements Runnable {
    private JFrameObject jFrameObject;
    private FactoryModel factoryModel;

    public void setJFrameObject(JFrameObject jFrameObject) {
        this.jFrameObject = jFrameObject;
    }

    public void setFactoryModel(FactoryModel factoryModel) {
        this.factoryModel = factoryModel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

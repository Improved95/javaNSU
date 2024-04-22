package org.lab4.view;

import org.lab4.jframe.JFrameObject;
import org.lab4.model.factory.FactoryModel;
import org.lab4.model.warehouse.Warehouse;

import java.util.Map;

import static java.lang.Thread.sleep;

public class FactoryView implements Runnable {
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
            Map<String, Warehouse> warehouseMap = factoryModel.getWarehousesMap();

            jFrameObject.setCarBodyWarehouseSize(warehouseMap.get("CarBody").getSize());
            jFrameObject.setCarBodyProviderTotalImportedDetailsNumber(factoryModel.getTotalImportedDetailsNumberOnCarBodyWarehouse().get());

            jFrameObject.setEngineWarehouseSize(warehouseMap.get("Engine").getSize());
            jFrameObject.setEngineProviderTotalImportedDetailsNumber(factoryModel.getTotalImportedDetailsNumberOnEngineWarehouse().get());

            jFrameObject.setAccessoryWarehouseSize(warehouseMap.get("Accessory").getSize());
            jFrameObject.setAccessoryProviderTotalImportedDetailsNumber(factoryModel.getTotalImportedDetailsNumberOnAccessoryWarehouse().get());

            jFrameObject.setReadyCarWarehouseSize(warehouseMap.get("ReadyCar").getSize());
            jFrameObject.setTotalReadyCarCreatedNumber(factoryModel.getTotalCreatedCarNumber().get());

            factoryModel.setCarBodyProviderDelay(jFrameObject.getCarBodyProviderDelay());
            factoryModel.setEngineProviderDelay(jFrameObject.getEngineProviderDelay());
            factoryModel.setAccessoryProviderDelay(jFrameObject.getAccessoryProviderDelay());
            factoryModel.setDealersRequestDelay(jFrameObject.getDealersRequestDelay());

            jFrameObject.getFrame().repaint();

            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

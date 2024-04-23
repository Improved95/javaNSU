package org.lab4.view;

import org.lab4.controller.Dealer;
import org.lab4.jframe.JFrameObject;
import org.lab4.model.factory.FactoryModel;
import org.lab4.model.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static java.lang.Thread.sleep;

public class FactoryView implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Dealer.class);
    private boolean isLogging;

    private JFrameObject jFrameObject;
    private FactoryModel factoryModel;

    public FactoryView(boolean isLogging) {
        this.isLogging = isLogging;
    }

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
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("FactoryView: ", ex); }
                return;
            }
        }
    }
}

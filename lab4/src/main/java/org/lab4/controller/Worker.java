package org.lab4.controller;

import org.lab4.model.details.*;
import org.lab4.model.warehouse.AccessoryWarehouse;
import org.lab4.model.warehouse.CarBodyWarehouse;
import org.lab4.model.warehouse.EngineWarehouse;
import org.lab4.model.warehouse.ReadyCarWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Worker implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Dealer.class);
    private boolean isLogging = false;

    private CarBodyWarehouse carBodyWarehouse;
    private EngineWarehouse engineWarehouse;
    private AccessoryWarehouse accessoryWarehouse;
    private ReadyCarWarehouse readyCarWarehouse;

    public Worker(boolean isLogging) {
        this.isLogging = isLogging;
    }

    public void setCarBodyWarehouse(CarBodyWarehouse carBodyWarehouse) {
        this.carBodyWarehouse = carBodyWarehouse;
    }

    public void setEngineWarehouse(EngineWarehouse engineWarehouse) {
        this.engineWarehouse = engineWarehouse;
    }

    public void setAccessoryWarehouse(AccessoryWarehouse accessoryWarehouse) {
        this.accessoryWarehouse = accessoryWarehouse;
    }

    public void setReadyCarWarehouse(ReadyCarWarehouse readyCarWarehouse) {
        this.readyCarWarehouse = readyCarWarehouse;
    }

    @Override
    public void run() {
        DetailsContext detailsContext = new DetailsContext();
        try {
            detailsContext.setCarBody((CarBody) carBodyWarehouse.pickUpDetail());
            detailsContext.setEngine((Engine) engineWarehouse.pickUpDetail());
            detailsContext.setAccessory((Accessory) accessoryWarehouse.pickUpDetail());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ReadyCar readyCar = new ReadyCar();
        readyCar.setDetailsContext(detailsContext);

        try {
            readyCarWarehouse.addDetail(readyCar);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.lab4.controller;

import org.lab4.model.details.*;
import org.lab4.model.factory.FactoryModel;
import org.lab4.model.warehouse.AccessoryWarehouse;
import org.lab4.model.warehouse.CarBodyWarehouse;
import org.lab4.model.warehouse.EngineWarehouse;
import org.lab4.model.warehouse.ReadyCarWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Worker extends Thread {
    private static final Logger log = LoggerFactory.getLogger(Dealer.class);
    private boolean isLogging;

    private CarBodyWarehouse carBodyWarehouse;
    private EngineWarehouse engineWarehouse;
    private AccessoryWarehouse accessoryWarehouse;
    private ReadyCarWarehouse readyCarWarehouse;

    private FactoryModel factoryModel;

    private AtomicInteger callNumber = new AtomicInteger(0);

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

    public void setFactoryModel(FactoryModel factoryModel) {
        this.factoryModel = factoryModel;
    }

    @Override
    public void run() {
        DetailsContext detailsContext = new DetailsContext();
        try {
            detailsContext.setCarBody((CarBody) carBodyWarehouse.pickUpDetail());
            detailsContext.setEngine((Engine) engineWarehouse.pickUpDetail());
            detailsContext.setAccessory((Accessory) accessoryWarehouse.pickUpDetail());
        } catch (InterruptedException ex) {
            if (isLogging) { log.error("Worker: ", ex); }
            return;
        }

        ReadyCar readyCar = new ReadyCar();
        readyCar.setDetailsContext(detailsContext);

        try {
//            sleep(2000); /* "полезная нагрузка" */

            readyCarWarehouse.addDetail(readyCar);
            factoryModel.getTotalCreatedCarNumber().incrementAndGet();

            if (isLogging) { log.info("Worker with id {}: add new car with id {}", 1, readyCar.getDetailId()); }
        } catch (InterruptedException ex) {
            if (isLogging) { log.error("Worker: ", ex); }
        }
    }
}

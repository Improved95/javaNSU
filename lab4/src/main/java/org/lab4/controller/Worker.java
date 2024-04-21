package org.lab4.controller;

import org.lab4.model.details.*;
import org.lab4.model.warehouse.AccessoryWarehouse;
import org.lab4.model.warehouse.CarBodyWarehouse;
import org.lab4.model.warehouse.EngineWarehouse;
import org.lab4.model.warehouse.ReadyCarWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Worker implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Dealer.class);
    private boolean isLogging;

    private CarBodyWarehouse carBodyWarehouse;
    private EngineWarehouse engineWarehouse;
    private AccessoryWarehouse accessoryWarehouse;
    private ReadyCarWarehouse readyCarWarehouse;

    private final int threadsNumber;
    AtomicInteger busyThreadsNumber = new AtomicInteger(0);

    public Worker(int threadsNumber, boolean isLogging) {
        this.threadsNumber = threadsNumber;
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

    public synchronized void freeThreadsIsExist() throws InterruptedException {
        while(busyThreadsNumber.get() >= threadsNumber) {
            wait();
        }
    }

    @Override
    public void run() {
        busyThreadsNumber.getAndIncrement();

        DetailsContext detailsContext = new DetailsContext();
        try {
            detailsContext.setCarBody((CarBody) carBodyWarehouse.pickUpDetail());
            detailsContext.setEngine((Engine) engineWarehouse.pickUpDetail());
            detailsContext.setAccessory((Accessory) accessoryWarehouse.pickUpDetail());
        } catch (InterruptedException ex) {
            if (isLogging) { log.error("Worker: ", ex); }
            throw new RuntimeException(ex);
        }

        ReadyCar readyCar = new ReadyCar();
        readyCar.setDetailsContext(detailsContext);

        try {
            readyCarWarehouse.addDetail(readyCar);
            if (isLogging) { log.info("Worker with id {}: add new car with id {}", 1, readyCar.getDetailId()); }
        } catch (InterruptedException ex) {
            if (isLogging) { log.error("Worker: ", ex); }
            throw new RuntimeException(ex);
        }

        busyThreadsNumber.getAndDecrement();
        notifyAll();
    }
}

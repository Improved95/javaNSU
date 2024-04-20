package org.lab4.controller;

import org.lab4.model.warehouse.ReadyCarWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

public class ReadyCarWarehouseController implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Dealer.class);
    private boolean isLogging;

    private Worker worker;
    private ThreadPoolExecutor workersThreadPool;
    private ReadyCarWarehouse readyCarWarehouse;

    public ReadyCarWarehouseController(boolean isLogging) {
        this.isLogging = isLogging;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void setWorkersThreadPool(ThreadPoolExecutor workersThreadPool) {
        this.workersThreadPool = workersThreadPool;
    }

    public void setWarehouse(ReadyCarWarehouse readyCarWarehouse) {
        this.readyCarWarehouse = readyCarWarehouse;
    }

    @Override
    public void run() {
        while (true) {
            try {
                readyCarWarehouse.isFilled();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            workersThreadPool.submit(() -> {
                worker.run();
            });
        }
    }
}

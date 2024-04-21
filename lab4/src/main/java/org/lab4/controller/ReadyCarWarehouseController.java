package org.lab4.controller;

import org.lab4.model.warehouse.ReadyCarWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.sleep;

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
                if (isLogging) { log.error("ReadyCarWarehouseController: ", ex); }
                throw new RuntimeException(ex);
            }

//            System.out.println("rcwc1 " + readyCarWarehouse.getSize());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            new Thread(worker).start();
            workersThreadPool.execute(() -> worker.run());
        }
    }
}

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

    private Dealer dealer;
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

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setWarehouse(ReadyCarWarehouse readyCarWarehouse) {
        this.readyCarWarehouse = readyCarWarehouse;
    }

    private synchronized void waitTask() {
        try {
            wait();
        } catch (InterruptedException ex) {
            if (isLogging) { log.error("ReadyCarWarehouseController: ", ex); }
            throw new RuntimeException(ex);
        }
    }

    public synchronized void sendNewTaskToWorker() {
        notifyAll();
    }

    @Override
    public void run() {
        while (true) {
            waitTask();
            System.out.println("ReadyCarWarehouseController");

            try {
                readyCarWarehouse.isFilled();
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("ReadyCarWarehouseController: ", ex); }
                throw new RuntimeException(ex);
            }

            workersThreadPool.execute(() -> worker.run());
        }
    }
}

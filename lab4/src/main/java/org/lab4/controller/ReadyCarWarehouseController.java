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

    boolean newTaskIsExist = false;
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

    private synchronized void waitNewTask() throws InterruptedException {
        while (!newTaskIsExist) {
            wait();
        }
        this.newTaskIsExist = false;
    }

    public synchronized void setNewTaskExist() {
        this.newTaskIsExist = true;
        notifyAll();
    }

    @Override
    public void run() {
        while (true) {
            try {
                waitNewTask();
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("ReadyCarWarehouseController: ", ex); }
                throw new RuntimeException(ex);
            }

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

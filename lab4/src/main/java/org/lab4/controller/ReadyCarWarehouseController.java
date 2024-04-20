package org.lab4.controller;

import org.lab4.model.warehouse.ReadyCarWarehouse;

import java.util.concurrent.ThreadPoolExecutor;

public class ReadyCarWarehouseController implements Runnable {
    private Worker worker;
    private ThreadPoolExecutor workersThreadPool;
    private ReadyCarWarehouse readyCarWarehouse;

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

            System.out.println("controller ready car");
            workersThreadPool.submit(() -> {
                worker.run();
            });
        }
    }
}

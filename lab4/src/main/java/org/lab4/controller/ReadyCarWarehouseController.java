package org.lab4.controller;

import org.lab4.model.warehouse.ReadyCarWarehouse;

import java.util.concurrent.ThreadPoolExecutor;

public class ReadyCarWarehouseController implements Runnable {
    private ReadyCarWarehouse readyCarWarehouse;
    private ThreadPoolExecutor workersThreadPool;

    public void setWarehouse(ReadyCarWarehouse readyCarWarehouse) {
        this.readyCarWarehouse = readyCarWarehouse;
    }

    public void setWorkersThreadPool(ThreadPoolExecutor workersThreadPool) {
        this.workersThreadPool = workersThreadPool;
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

            });
        }
    }
}

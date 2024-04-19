package org.lab4.controller.warehouse;

import org.lab4.model.warehouse.ReadyCarWarehouse;

public class ReadyCarWarehouseController implements Runnable {
    private ReadyCarWarehouse readyCarWarehouse;

    public void setWarehouse(ReadyCarWarehouse readyCarWarehouse) {
        this.readyCarWarehouse = readyCarWarehouse;
    }

    @Override
    public void run() {

    }
}

package org.lab4.model.warehouse;

public class ReadyCarWarehouse extends AbstractWarehouse {
    public ReadyCarWarehouse(int size) {
        super(size);
    }

    @Override
    public synchronized void isFilled() throws InterruptedException {
        while (size == fillSize) {
            wait();
        }
    }
}

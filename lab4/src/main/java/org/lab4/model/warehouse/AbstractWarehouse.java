package org.lab4.model.warehouse;

public class AbstractWarehouse implements Warehouse {
    private final int size;
    private int fillSize = 0;

    public AbstractWarehouse(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFillSize() {
        return fillSize;
    }

    @Override
    public void addItem() {
        fillSize += 1;
    }

    @Override
    public void pickUpItem() {
        fillSize -= 1;
    }
}

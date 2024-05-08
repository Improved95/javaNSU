package org.lab4.model.warehouse;

import org.lab4.model.dataStruct.MyConcurrentQueue;
import org.lab4.model.details.Detail;

public class AbstractWarehouse implements Warehouse {
    protected final int capacity;
    protected int size;

    protected MyConcurrentQueue detailList;

    public AbstractWarehouse(int capacity) {
        this.capacity = capacity;
        this.detailList = new MyConcurrentQueue<Detail>();
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public synchronized int getSize() {
        return size;
    }

    @Override
    public synchronized void isFilled() throws InterruptedException {
        while (size >= capacity) {
            wait();
        }
    }

    @Override
    public synchronized void addDetail(Detail detail) throws InterruptedException {
        while (size >= capacity) {
            wait();
        }
        detailList.add(detail);
        size++;
        notifyAll();
    }

    @Override
    public synchronized Detail pickUpDetail() throws InterruptedException {
        while (size <= 0) {
            wait();
        }
        Detail detail = (Detail) detailList.removeLast();
        size--;
        notifyAll();
        return detail;
    }

    @Override
    public synchronized Detail unblockPickUpDetail() {
        if (size <= 0) {
            return null;
        }
        Detail detail = (Detail) detailList.removeLast();
        size--;
        notifyAll();
        return detail;
    }
}

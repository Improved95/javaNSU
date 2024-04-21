package org.lab4.model.warehouse;

import org.lab4.model.dataStruct.MyConcurrentQueue;
import org.lab4.model.details.Detail;

import java.util.concurrent.atomic.AtomicInteger;

public class AbstractWarehouse implements Warehouse {
    protected final int capacity;
//    protected int size;
    AtomicInteger size = new AtomicInteger(0);

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
        return size.get();
    }

    @Override
    public synchronized void isFilled() throws InterruptedException {
        while (size.get() >= capacity) {
            wait();
        }
    }

    @Override
    public synchronized void addDetail(Detail detail) throws InterruptedException {
        while (size.get() >= capacity) {
            wait();
        }
        detailList.add(detail);
        size.incrementAndGet();
        notify();
    }

    @Override
    public synchronized Detail pickUpDetail() throws InterruptedException {
        while (size.get() <= 0) {
            wait();
        }
        Detail detail = (Detail) detailList.removeLast();
        size.decrementAndGet();
        notify();
        return detail;
    }
}

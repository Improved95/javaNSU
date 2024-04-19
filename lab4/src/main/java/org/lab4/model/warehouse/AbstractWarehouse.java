package org.lab4.model.warehouse;

import org.lab4.model.dataStruct.MyConcurrentQueue;
import org.lab4.model.details.Detail;

public class AbstractWarehouse implements Warehouse {
    protected final int size;
    protected int fillSize;

    protected MyConcurrentQueue detailList;

    public AbstractWarehouse(int size) {
        this.size = size;
        this.detailList = new MyConcurrentQueue<Detail>();
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
    public synchronized void isFilled() throws InterruptedException {
    }

    @Override
    public synchronized void addDetail(Detail detail) throws InterruptedException {
        while (fillSize >= size) {
            wait();
        }
        fillSize++;
        detailList.add(detail);
        notifyAll();
    }

    @Override
    public synchronized Detail pickUpDetail() throws InterruptedException {
        while (fillSize <= 0) {
            wait();
        }
        fillSize--;
        notifyAll();
        return (Detail) detailList.removeLast();
    }
}

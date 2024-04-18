package org.lab4.model.warehouse;

import org.lab4.model.dataStruct.MyConcurrentQueue;
import org.lab4.model.details.Detail;

import java.util.concurrent.atomic.AtomicInteger;

public class AbstractWarehouse implements Warehouse {
    private final int size;
    private AtomicInteger fillSize = new AtomicInteger();

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
        return fillSize.get();
    }

    @Override
    public void addDetail(Detail detail) {
        detailList.add(detail);
    }

    @Override
    public void pickUpDetail() {
        detailList.removeLast();
    }
}

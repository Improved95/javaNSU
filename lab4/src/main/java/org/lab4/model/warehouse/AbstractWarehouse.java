package org.lab4.model.warehouse;

import org.lab4.model.details.Detail;

import java.util.ArrayList;
import java.util.List;

public class AbstractWarehouse implements Warehouse {
    private final int size;
    private int fillSize = 0;

    private List<Detail> detailsList = new ArrayList<>();

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
    public List<Detail> getDetailsList() {
        return detailsList;
    }

    @Override
    public void addDetail(Detail detail) {
        detailsList.add(detail);
        fillSize += 1;
    }

    @Override
    public void pickUpDetail() {
        fillSize -= 1;
    }
}

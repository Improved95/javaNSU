package org.lab4.model.warehouse;

import org.lab4.model.details.Detail;

import java.util.List;

public interface Warehouse {
    int getSize();

    int getFillSize();

    List<Detail> getDetailsList();

    void addDetail(Detail detail);

    void pickUpDetail();
}

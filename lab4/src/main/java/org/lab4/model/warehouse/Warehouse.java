package org.lab4.model.warehouse;

import org.lab4.model.details.Detail;


public interface Warehouse {
    int getSize();

    int getFillSize();

    void addDetail(Detail detail);

    void pickUpDetail();
}

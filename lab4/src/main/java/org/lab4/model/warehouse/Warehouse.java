package org.lab4.model.warehouse;

import org.lab4.model.details.Detail;


public interface Warehouse {
    int getSize();

    int getFillSize();

    void isFilled() throws InterruptedException;

    void addDetail(Detail detail) throws InterruptedException;

    Detail pickUpDetail() throws InterruptedException;
}

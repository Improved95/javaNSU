package org.lab4.model.warehouse;

public interface Warehouse {

    int getSize();

    int getFillSize();

    void addItem();

    void pickUpItem();
}

package org.lab4.model.details;

public class CarBody extends AbstractDetail {
    private static int nextUniqueId = 0;

    public CarBody() {
        this.detailId = nextUniqueId;
        nextUniqueId++;
    }
}

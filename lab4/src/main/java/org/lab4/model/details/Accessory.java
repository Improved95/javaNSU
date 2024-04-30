package org.lab4.model.details;

public class Accessory extends AbstractDetail {
    private static int nextUniqueId = 0;

    public Accessory() {
        this.detailId = nextUniqueId;
        nextUniqueId++;
    }
}

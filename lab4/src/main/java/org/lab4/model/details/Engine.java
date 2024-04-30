package org.lab4.model.details;

public class Engine extends AbstractDetail {
    private static int nextUniqueId = 0;

    public Engine() {
        this.detailId = nextUniqueId;
        nextUniqueId++;
    }
}

package org.lab4.model.details;

public class ReadyCar extends AbstractDetail {
    private static int nextUniqueId = 0;
    private DetailsContext detailsContext;

    public ReadyCar() {
        this.detailId = nextUniqueId;
        nextUniqueId++;
    }
}
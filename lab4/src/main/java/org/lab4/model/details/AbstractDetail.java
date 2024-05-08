package org.lab4.model.details;

public class AbstractDetail implements Detail {
    protected int detailId;

    @Override
    public int getDetailId() {
        return detailId;
    }
}

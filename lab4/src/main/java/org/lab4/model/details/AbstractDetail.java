package org.lab4.model.details;

public class AbstractDetail implements Detail {
    private static int detailIdNextUnique = 0;
    private int detailId;

    public AbstractDetail() {
        this.detailId = detailIdNextUnique;
        detailIdNextUnique++;
    }

    @Override
    public int getDetailId() {
        return detailId;
    }
}

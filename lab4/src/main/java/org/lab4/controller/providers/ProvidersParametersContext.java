package org.lab4.controller.providers;

import org.lab4.jframe.JFrameObject;
import org.lab4.model.warehouse.Warehouse;

public class ProvidersParametersContext {
    private Warehouse warehouse;
    private JFrameObject jFrameObject;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public JFrameObject getJFrameObject() {
        return jFrameObject;
    }

    public void setJFrameObject(JFrameObject jFrameObject) {
        this.jFrameObject = jFrameObject;
    }
}

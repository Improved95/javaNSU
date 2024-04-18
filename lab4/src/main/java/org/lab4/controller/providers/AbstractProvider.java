package org.lab4.controller.providers;

import org.lab4.jframe.JFrameObject;
import org.lab4.model.warehouse.Warehouse;


public abstract class AbstractProvider implements Provider {
//    protected ProvidersParametersContext parametersContext = new ProvidersParametersContext();
    protected Warehouse warehouse;
    protected JFrameObject jFrameObject;
    protected int sleepTime;

//    @Override
//    public ProvidersParametersContext getParametersContext() {
//        return parametersContext;
//    }

    @Override
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void setJFrameObject(JFrameObject jFrameObject) {
        this.jFrameObject = jFrameObject;
    }
}

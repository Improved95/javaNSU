package org.lab4.controller.providers;

import org.lab4.jframe.JFrameObject;
import org.lab4.model.warehouse.Warehouse;

public interface Provider extends Runnable {
    void setWarehouse(Warehouse warehouse);

    void setJFrameObject(JFrameObject jFrameObject);
//    ProvidersParametersContext getParametersContext();
}

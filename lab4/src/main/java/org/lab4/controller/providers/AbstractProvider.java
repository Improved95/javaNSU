package org.lab4.controller.providers;

import org.lab4.controller.Dealer;
import org.lab4.jframe.JFrameObject;
import org.lab4.model.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AbstractProvider implements Provider {
    protected static final Logger log = LoggerFactory.getLogger(Dealer.class);
    protected boolean isLogging = false;

    protected Warehouse warehouse;
    protected JFrameObject jFrameObject;
    protected int sleepTime;

    public AbstractProvider(boolean isLogging) {
        this.isLogging = isLogging;
    }

    @Override
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void setJFrameObject(JFrameObject jFrameObject) {
        this.jFrameObject = jFrameObject;
    }
}

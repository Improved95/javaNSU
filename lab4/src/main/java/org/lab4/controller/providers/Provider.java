package org.lab4.controller.providers;

import org.lab4.model.warehouse.Warehouse;

public interface Provider extends Runnable {

    ProvidersParametersContext getParametersContext();
}

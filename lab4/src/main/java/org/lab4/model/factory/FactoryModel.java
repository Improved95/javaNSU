package org.lab4.model.factory;

import org.lab4.controller.providers.Provider;
import org.lab4.model.warehouse.Warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class FactoryModel {
    private Properties factoryProperties;
    private Map<String, Provider> providersMap = new HashMap<>();
    private Map<String, Warehouse> warehousesMap = new HashMap<>();

    AtomicInteger readyCarNumber = new AtomicInteger(0);

    public Properties getFactoryProperties() {
        return factoryProperties;
    }

    public void setFactoryProperties(Properties factoryProperties) {
        this.factoryProperties = factoryProperties;
    }

    public Map<String, Provider> getProvidersMap() {
        return providersMap;
    }

    public void setProvidersMap(Map<String, Provider> providersMap) {
        this.providersMap = providersMap;
    }

    public Map<String, Warehouse> getWarehousesMap() {
        return warehousesMap;
    }

    public void setWarehousesMap(Map<String, Warehouse> warehousesMap) {
        this.warehousesMap = warehousesMap;
    }
}
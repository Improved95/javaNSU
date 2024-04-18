package org.lab4.model.factory;

import org.lab4.controller.providers.Provider;
import org.lab4.model.warehouse.Warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FactoryModel {
    private Properties factoryProperties;
    private Map<String, List<Provider>> providersMap = new HashMap<>();
    private Map<String, List<Warehouse>> warehousesMap = new HashMap<>();

    public Properties getFactoryProperties() {
        return factoryProperties;
    }

    public void setFactoryProperties(Properties factoryProperties) {
        this.factoryProperties = factoryProperties;
    }

    public Map<String, List<Provider>> getProvidersMap() {
        return providersMap;
    }

    public void setProvidersMap(Map<String, List<Provider>> providersMap) {
        this.providersMap = providersMap;
    }

    public Map<String, List<Warehouse>> getWarehousesMap() {
        return warehousesMap;
    }

    public void setWarehousesMap(Map<String, List<Warehouse>> warehousesMap) {
        this.warehousesMap = warehousesMap;
    }
}

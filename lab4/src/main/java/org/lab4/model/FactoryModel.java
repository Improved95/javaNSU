package org.lab4.model;

import org.lab4.model.providers.Provider;
import org.lab4.model.warehouse.Warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FactoryModel {
    private Properties factoryConfig;
    private Map<String, List<Provider>> providersMap = new HashMap<>();
    private Map<String, List<Warehouse>> warehousesMap = new HashMap<>();

    public Properties getFactoryConfig() {
        return factoryConfig;
    }

    public void setFactoryConfig(Properties factoryConfig) {
        this.factoryConfig = factoryConfig;
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

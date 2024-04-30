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

    AtomicInteger totalImportedDetailsNumberOnCarBodyWarehouse = new AtomicInteger(0);
    AtomicInteger totalImportedDetailsNumberOnEngineWarehouse = new AtomicInteger(0);
    AtomicInteger totalImportedDetailsNumberOnAccessoryWarehouse = new AtomicInteger(0);
    AtomicInteger totalCreatedCarNumber = new AtomicInteger(0);

    int carBodyProviderDelay = Integer.MAX_VALUE;
    int engineProviderDelay = 1000;
    int accessoryProviderDelay = 1000;
    int dealersRequestDelay = 1000;

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

    public AtomicInteger getTotalImportedDetailsNumberOnCarBodyWarehouse() {
        return totalImportedDetailsNumberOnCarBodyWarehouse;
    }

    public AtomicInteger getTotalImportedDetailsNumberOnEngineWarehouse() {
        return totalImportedDetailsNumberOnEngineWarehouse;
    }

    public AtomicInteger getTotalImportedDetailsNumberOnAccessoryWarehouse() {
        return totalImportedDetailsNumberOnAccessoryWarehouse;
    }

    public AtomicInteger getTotalCreatedCarNumber() {
        return totalCreatedCarNumber;
    }

    public int getCarBodyProviderDelay() {
        return carBodyProviderDelay;
    }

    public void setCarBodyProviderDelay(int carBodyProviderDelay) {
        this.carBodyProviderDelay = carBodyProviderDelay;
    }

    public int getEngineProviderDelay() {
        return engineProviderDelay;
    }

    public void setEngineProviderDelay(int engineProviderDelay) {
        this.engineProviderDelay = engineProviderDelay;
    }

    public int getAccessoryProviderDelay() {
        return accessoryProviderDelay;
    }

    public void setAccessoryProviderDelay(int accessoryProviderDelay) {
        this.accessoryProviderDelay = accessoryProviderDelay;
    }

    public int getDealersRequestDelay() {
        return dealersRequestDelay;
    }

    public void setDealersRequestDelay(int dealersRequestDelay) {
        this.dealersRequestDelay = dealersRequestDelay;
    }
}

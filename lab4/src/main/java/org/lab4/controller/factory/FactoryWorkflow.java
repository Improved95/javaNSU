package org.lab4.controller.factory;

import org.lab4.controller.providers.AccessoryProvider;
import org.lab4.controller.providers.CarBodyProvider;
import org.lab4.controller.providers.EngineProvider;
import org.lab4.controller.providers.Provider;
import org.lab4.jframe.JFrameObject;
import org.lab4.model.factory.FactoryModel;
import org.lab4.model.warehouse.CarBodyWarehouse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FactoryWorkflow {
    private JFrameObject jFrameObject;
    private FactoryModel factoryModel = new FactoryModel();

    public FactoryWorkflow() {
        initial();
    }

    public void execute() {
        initialCarBodyProvider();
        initialEngineProvider();
        initialAccessoryProvider();
    }

    private void initialCarBodyProvider() {
        Provider carBodyProvider = new CarBodyProvider();
        carBodyProvider.setWarehouse(factoryModel.getWarehousesMap().get("CarBody"));
        carBodyProvider.setJFrameObject(jFrameObject);
        new Thread(carBodyProvider).start();
    }

    private void initialEngineProvider() {
        Provider engineProvider = new EngineProvider();
        engineProvider.setWarehouse(factoryModel.getWarehousesMap().get("Engine"));
        engineProvider.setJFrameObject(jFrameObject);
        new Thread(engineProvider).start();
    }

    private void initialAccessoryProvider() {
        Provider accessoryProvider = new AccessoryProvider();
        accessoryProvider.setWarehouse(factoryModel.getWarehousesMap().get("Accessory"));
        accessoryProvider.setJFrameObject(jFrameObject);

        int accessoryProviderNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < accessoryProviderNumber; i++) {
            new Thread(accessoryProvider).start();
        }
    }

    private void initial() {
        jFrameObject = new JFrameObject();

        try (InputStream config = this.getClass().getResourceAsStream("../../../../config")) {
            factoryModel.setFactoryProperties(ConfigParser.parse(config));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Properties factoryProperty = factoryModel.getFactoryProperties();
        factoryModel.getWarehousesMap().put("CarBody", new CarBodyWarehouse(Integer.parseInt(factoryProperty.getProperty("carBodyWarehouseSize"))));
        factoryModel.getWarehousesMap().put("Engine", new CarBodyWarehouse(Integer.parseInt(factoryProperty.getProperty("engineWarehouseSize"))));
        factoryModel.getWarehousesMap().put("Accessory", new CarBodyWarehouse(Integer.parseInt(factoryProperty.getProperty("accessoryWarehouseSize"))));
        factoryModel.getWarehousesMap().put("ReadyCar", new CarBodyWarehouse(Integer.parseInt(factoryProperty.getProperty("readyCarWarehouseSize"))));
    }
}

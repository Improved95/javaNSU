package org.lab4.controller.factory;

import org.lab4.controller.Dealer;
import org.lab4.controller.providers.AccessoryProvider;
import org.lab4.controller.providers.CarBodyProvider;
import org.lab4.controller.providers.EngineProvider;
import org.lab4.controller.providers.Provider;
import org.lab4.controller.warehouse.ReadyCarWarehouseController;
import org.lab4.jframe.JFrameObject;
import org.lab4.model.factory.FactoryModel;
import org.lab4.model.warehouse.AccessoryWarehouse;
import org.lab4.model.warehouse.CarBodyWarehouse;
import org.lab4.model.warehouse.EngineWarehouse;
import org.lab4.model.warehouse.ReadyCarWarehouse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FactoryWorkflow {
    private JFrameObject jFrameObject;
    private FactoryModel factoryModel = new FactoryModel();

    private Provider carBodyProvider;
    private Provider engineProvider;
    private Provider accessoryProvider;

    private ReadyCarWarehouseController readyCarWarehouseController;
    private Dealer dealer;

    public FactoryWorkflow() {
        initial();
    }

    public void execute() {

        initialCarBodyProvider();
        initialEngineProvider();
        initialAccessoryProvider();
        initialDealers();
    }

    private void initialCarBodyProvider() {
        carBodyProvider = new CarBodyProvider();
        carBodyProvider.setWarehouse(factoryModel.getWarehousesMap().get("CarBody"));
        carBodyProvider.setJFrameObject(jFrameObject);
        new Thread(carBodyProvider).start();
    }

    private void initialEngineProvider() {
        engineProvider = new EngineProvider();
        engineProvider.setWarehouse(factoryModel.getWarehousesMap().get("Engine"));
        engineProvider.setJFrameObject(jFrameObject);
        new Thread(engineProvider).start();
    }

    private void initialAccessoryProvider() {
        accessoryProvider = new AccessoryProvider();
        accessoryProvider.setWarehouse(factoryModel.getWarehousesMap().get("Accessory"));
        accessoryProvider.setJFrameObject(jFrameObject);

        int accessoryProvidersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < accessoryProvidersNumber; i++) {
            new Thread(accessoryProvider).start();
        }
    }

    private void initialReadyCarWarehouseController() {
        readyCarWarehouseController = new ReadyCarWarehouseController();
        readyCarWarehouseController.setWarehouse((ReadyCarWarehouse) factoryModel.getWarehousesMap().get("ReadyCar"));


    }

    private void initialDealers() {
        dealer = new Dealer();
        dealer.setJFrameObject(jFrameObject);
        dealer.setReadyCarWarehouse((ReadyCarWarehouse) factoryModel.getWarehousesMap().get("ReadyCar"));

        int dealersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < dealersNumber; i++) {
            new Thread(dealer).start();
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
        factoryModel.getWarehousesMap().put("Engine", new EngineWarehouse(Integer.parseInt(factoryProperty.getProperty("engineWarehouseSize"))));
        factoryModel.getWarehousesMap().put("Accessory", new AccessoryWarehouse(Integer.parseInt(factoryProperty.getProperty("accessoryWarehouseSize"))));
        factoryModel.getWarehousesMap().put("ReadyCar", new ReadyCarWarehouse(Integer.parseInt(factoryProperty.getProperty("readyCarWarehouseSize"))));
    }
}

package org.lab4.controller.factory;

import org.lab4.controller.Dealer;
import org.lab4.controller.Worker;
import org.lab4.controller.providers.AccessoryProvider;
import org.lab4.controller.providers.CarBodyProvider;
import org.lab4.controller.providers.EngineProvider;
import org.lab4.controller.providers.Provider;
import org.lab4.controller.ReadyCarWarehouseController;
import org.lab4.jframe.JFrameObject;
import org.lab4.model.factory.FactoryModel;
import org.lab4.model.warehouse.AccessoryWarehouse;
import org.lab4.model.warehouse.CarBodyWarehouse;
import org.lab4.model.warehouse.EngineWarehouse;
import org.lab4.model.warehouse.ReadyCarWarehouse;
import org.lab4.view.FactoryView;

import javax.swing.text.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FactoryWorkflow {
    private JFrameObject jFrameObject;
    private FactoryModel factoryModel = new FactoryModel();
    private FactoryView view;

    private Provider carBodyProvider;
    private Provider engineProvider;
    private Provider accessoryProvider;

    private Worker worker;
    private ThreadPoolExecutor workersThreadPool;

    private ReadyCarWarehouseController readyCarWarehouseController;
    private Dealer dealer;

    public FactoryWorkflow() {
        initial();
    }

    public void execute() {
        new Thread(view).start();

        new Thread(carBodyProvider).start();
        new Thread(engineProvider).start();

        int accessoryProvidersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < accessoryProvidersNumber; i++) {
            new Thread(accessoryProvider).start();
        }

        int dealersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < dealersNumber; i++) {
            new Thread(dealer).start();
        }

        new Thread(readyCarWarehouseController).start();
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

        initialView();

        initialCarBodyProvider();
        initialEngineProvider();
        initialAccessoryProvider();
        initialWorker();
        initialWorkersThreadPool();
        initialReadyCarWarehouseController();
        initialDealers();
    }

    private void initialCarBodyProvider() {
        carBodyProvider = new CarBodyProvider(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        carBodyProvider.setWarehouse(factoryModel.getWarehousesMap().get("CarBody"));
        carBodyProvider.setFactoryModel(factoryModel);
    }

    private void initialEngineProvider() {
        engineProvider = new EngineProvider(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        engineProvider.setWarehouse(factoryModel.getWarehousesMap().get("Engine"));
        engineProvider.setFactoryModel(factoryModel);
    }

    private void initialAccessoryProvider() {
        accessoryProvider = new AccessoryProvider(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        accessoryProvider.setWarehouse(factoryModel.getWarehousesMap().get("Accessory"));
        accessoryProvider.setFactoryModel(factoryModel);
    }

    private void initialWorker() {
        worker = new Worker(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        worker.setCarBodyWarehouse((CarBodyWarehouse) factoryModel.getWarehousesMap().get("CarBody"));
        worker.setEngineWarehouse((EngineWarehouse) factoryModel.getWarehousesMap().get("Engine"));
        worker.setAccessoryWarehouse((AccessoryWarehouse) factoryModel.getWarehousesMap().get("Accessory"));
        worker.setReadyCarWarehouse((ReadyCarWarehouse) factoryModel.getWarehousesMap().get("ReadyCar"));
        worker.setFactoryModel(factoryModel);
    }

    private void initialWorkersThreadPool() {
        workersThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(
                Integer.parseInt(factoryModel.getFactoryProperties().getProperty("workersNumber"))
        );
    }

    private void initialReadyCarWarehouseController() {
        readyCarWarehouseController = new ReadyCarWarehouseController(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        readyCarWarehouseController.setWarehouse((ReadyCarWarehouse) factoryModel.getWarehousesMap().get("ReadyCar"));
        readyCarWarehouseController.setWorkersThreadPool(workersThreadPool);
        readyCarWarehouseController.setWorker(worker);
    }

    private void initialDealers() {
        dealer = new Dealer(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        dealer.setFactoryModel(factoryModel);
        dealer.setReadyCarWarehouse((ReadyCarWarehouse) factoryModel.getWarehousesMap().get("ReadyCar"));
        dealer.setReadyCarWarehouseController(readyCarWarehouseController);
    }

    private void initialView() {
        view = new FactoryView();
        view.setJFrameObject(jFrameObject);
        view.setFactoryModel(factoryModel);
    }
}

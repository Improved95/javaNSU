package org.lab4.controller.factory;

import org.lab4.controller.Dealer;
import org.lab4.controller.Worker;
import org.lab4.controller.myThreadPool.MyThreadPool;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FactoryWorkflow {
    protected static final Logger log = LoggerFactory.getLogger(Dealer.class);
    protected boolean isLogging;

    private JFrameObject jFrameObject;
    private FactoryModel factoryModel = new FactoryModel();
    private FactoryView view;

    private Provider carBodyProvider;
    private Provider engineProvider;
    private Provider accessoryProvider;

    private Worker worker;
    private ReadyCarWarehouseController readyCarWarehouseController;
    private Dealer dealer;

    private Thread viewThread;
    private Thread carBodyProviderThread;
    private Thread engineProviderThread;
    private List<Thread> accessoryProvidersThreadsList = new ArrayList<>();
    private Thread readyCarWarehouseControllerThread;
    private List<Thread> dealersThreadsList = new ArrayList<>();
    private MyThreadPool workersThreadPool;

    public FactoryWorkflow() {
        initial();
    }

    public void execute() {
        viewThread.start();

        carBodyProviderThread.start();
        engineProviderThread.start();

        int accessoryProvidersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < accessoryProvidersNumber; i++) {
            accessoryProvidersThreadsList.get(i).start();
        }

        readyCarWarehouseControllerThread.start();

        int dealersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < dealersNumber; i++) {
            dealersThreadsList.get(i).start();
        }

        if (isLogging) { log.info("All threads started"); }
    }

    public void stopThreads() {
        viewThread.interrupt();
        carBodyProviderThread.interrupt();
        engineProviderThread.interrupt();
        int accessoryProvidersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < accessoryProvidersNumber; i++) {
            accessoryProvidersThreadsList.get(i).interrupt();
        }

        readyCarWarehouseControllerThread.interrupt();

        int dealersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < dealersNumber; i++) {
            dealersThreadsList.get(i).interrupt();
        }

        workersThreadPool.interrupt();

        if (isLogging) { log.info("All threads interrupted by close window"); }
    }

    private void initial() {
        jFrameObject = new JFrameObject();
        jFrameObject.setFactoryWorkflow(this);

        try (InputStream config = this.getClass().getResourceAsStream("../../../../config")) {
            factoryModel.setFactoryProperties(ConfigParser.parse(config));
        } catch (IOException ex) {
            log.error("Factory workflow: ", ex);
            ex.printStackTrace();
        }

        this.isLogging = Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"));

        Properties factoryProperty = factoryModel.getFactoryProperties();
        factoryModel.getWarehousesMap().put("CarBody", new CarBodyWarehouse(Integer.parseInt(factoryProperty.getProperty("carBodyWarehouseSize"))));
        factoryModel.getWarehousesMap().put("Engine", new EngineWarehouse(Integer.parseInt(factoryProperty.getProperty("engineWarehouseSize"))));
        factoryModel.getWarehousesMap().put("Accessory", new AccessoryWarehouse(Integer.parseInt(factoryProperty.getProperty("accessoryWarehouseSize"))));
        factoryModel.getWarehousesMap().put("ReadyCar", new ReadyCarWarehouse(Integer.parseInt(factoryProperty.getProperty("readyCarWarehouseSize"))));

        initialWorkersThreadPool();
        initialView();

        initialCarBodyProvider();
        initialEngineProvider();
        initialAccessoryProvider();
        initialWorker();
        initialReadyCarWarehouseController();
        initialDealers();

        if (isLogging) { log.info("Initialed all components."); }
    }

    private void initialCarBodyProvider() {
        carBodyProvider = new CarBodyProvider(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        carBodyProvider.setWarehouse(factoryModel.getWarehousesMap().get("CarBody"));
        carBodyProvider.setFactoryModel(factoryModel);

        carBodyProviderThread = new Thread(carBodyProvider);
    }

    private void initialEngineProvider() {
        engineProvider = new EngineProvider(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        engineProvider.setWarehouse(factoryModel.getWarehousesMap().get("Engine"));
        engineProvider.setFactoryModel(factoryModel);

        engineProviderThread = new Thread(engineProvider);
    }

    private void initialAccessoryProvider() {
        accessoryProvider = new AccessoryProvider(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        accessoryProvider.setWarehouse(factoryModel.getWarehousesMap().get("Accessory"));
        accessoryProvider.setFactoryModel(factoryModel);

        int accessoryProvidersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < accessoryProvidersNumber; i++) {
            accessoryProvidersThreadsList.add(i, new Thread(accessoryProvider));
        }
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
        workersThreadPool = new MyThreadPool(
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

        readyCarWarehouseControllerThread = new Thread(readyCarWarehouseController);
    }

    private void initialDealers() {
        dealer = new Dealer(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        dealer.setFactoryModel(factoryModel);
        dealer.setReadyCarWarehouse((ReadyCarWarehouse) factoryModel.getWarehousesMap().get("ReadyCar"));
        dealer.setReadyCarWarehouseController(readyCarWarehouseController);

        int dealersNumber = Integer.parseInt(factoryModel.getFactoryProperties().getProperty("accessoryProvidersNumber"));
        for (int i = 0; i < dealersNumber; i++) {
            dealersThreadsList.add(i, new Thread(dealer));
        }
    }

    private void initialView() {
        view = new FactoryView(
                Boolean.getBoolean(factoryModel.getFactoryProperties().getProperty("isLogging"))
        );
        view.setJFrameObject(jFrameObject);
        view.setFactoryModel(factoryModel);
        view.setThreadPool(workersThreadPool);

        viewThread = new Thread(view);
    }
}

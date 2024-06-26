package org.lab4.controller.providers;

import org.lab4.model.details.Engine;

import static java.lang.Thread.sleep;

public class EngineProvider extends AbstractProvider {
    public EngineProvider(boolean isLogging) {
        super(isLogging);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Engine engine = new Engine();
                warehouse.addDetail(engine);
                factoryModel.getTotalImportedDetailsNumberOnEngineWarehouse().incrementAndGet();
                if (isLogging) { log.info("EngineProvider: add new Engine with id: {}", engine.getDetailId()); }
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("EngineProvider: ", ex); }
                return;
            }

            try {
                sleep(factoryModel.getEngineProviderDelay());
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("CarBodyProvider: ", ex); }
                return;
            }
        }
    }
}

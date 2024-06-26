package org.lab4.controller.providers;

import org.lab4.model.details.Accessory;

import static java.lang.Thread.sleep;

public class AccessoryProvider extends AbstractProvider {
    public AccessoryProvider(boolean isLogging) {
        super(isLogging);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Accessory accessory = new Accessory();
                warehouse.addDetail(accessory);
                factoryModel.getTotalImportedDetailsNumberOnAccessoryWarehouse().incrementAndGet();
                if (isLogging) { log.info("AccessoryProvider: add new accessory with id: {}", accessory.getDetailId()); }
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("AccessoryProvider: ", ex); }
            }

            try {
                sleep(factoryModel.getAccessoryProviderDelay());
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("AccessoryProvider: ", ex); }
            }
        }
    }
}

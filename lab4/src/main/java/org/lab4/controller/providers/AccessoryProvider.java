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
            Accessory accessory = new Accessory();
            try {
//                System.out.println("Accessory: " + warehouse.getSize());
                warehouse.addDetail(accessory);
                if (isLogging) { log.info("AccessoryProvider: add new accessory with id: {}", accessory.getDetailId()); }
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("AccessoryProvider: ", ex); }
                throw new RuntimeException(ex);
            }

            sleepTime = jFrameObject.getAccessoryProviderDelay();
            try {
                sleep(sleepTime);
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("AccessoryProvider: ", ex); }
                throw new RuntimeException(ex);
            }
        }
    }
}

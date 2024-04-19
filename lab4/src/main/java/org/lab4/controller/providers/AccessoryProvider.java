package org.lab4.controller.providers;

import org.lab4.model.details.Accessory;

import static java.lang.Thread.sleep;

public class AccessoryProvider extends AbstractProvider {
    @Override
    public void run() {
        while (true) {
            try {
                warehouse.addDetail(new Accessory());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println("Accessory provider");
            sleepTime = jFrameObject.getAccessoryProviderDelay();
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

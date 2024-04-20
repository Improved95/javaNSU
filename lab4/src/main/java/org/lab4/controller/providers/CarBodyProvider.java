package org.lab4.controller.providers;

import org.lab4.model.details.CarBody;

import static java.lang.Thread.sleep;

public class CarBodyProvider extends AbstractProvider {
    public CarBodyProvider(boolean isLogging) {
        super(isLogging);
    }

    @Override
    public void run() {
        while (true) {
            try {
                warehouse.addDetail(new CarBody());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println("car body provider");
            sleepTime = jFrameObject.getCarBodyProviderDelay();
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

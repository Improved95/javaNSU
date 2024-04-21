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
                CarBody carBody = new CarBody();
                warehouse.addDetail(carBody);
                if (isLogging) { log.info("CarBodyProvider: add new carBody with id: {}", carBody.getDetailId()); }
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("CarBodyProvider: ", ex); }
                throw new RuntimeException(ex);
            }

            sleepTime = jFrameObject.getCarBodyProviderDelay();
            try {
                sleep(sleepTime);
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("CarBodyProvider: ", ex); }
                throw new RuntimeException(ex);
            }
        }
    }
}

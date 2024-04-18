package org.lab4.controller.providers;

import org.lab4.model.details.CarBody;

import static java.lang.Thread.sleep;

public class CarBodyProvider extends AbstractProvider {
    @Override
    public void run() {
        while (true) {
            System.out.println("car body provider");

            try {
                warehouse.addDetail(new CarBody());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            sleepTime = jFrameObject.getCarBodyProviderSleepTime();
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

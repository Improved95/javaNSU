package org.lab4.controller.providers;

import org.lab4.model.details.Engine;

import static java.lang.Thread.sleep;

public class EngineProvider extends AbstractProvider {
    @Override
    public void run() {
        while (true) {
            try {
                warehouse.addDetail(new Engine());
                System.out.println("Engine provider");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            sleepTime = jFrameObject.getEngineProviderDelay();
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

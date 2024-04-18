package org.lab4.controller.providers;

import static java.lang.Thread.sleep;

public class AbstractProvider implements Provider {
    private ProvidersParametersContext parametersContext = new ProvidersParametersContext();
    private int sleepTime;

    @Override
    public void run() {
        while (true) {
            System.out.println("car body provider");
            sleepTime = parametersContext.getJFrameObject().getCarBodyProviderSleepTime();
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public ProvidersParametersContext getParametersContext() {
        return parametersContext;
    }
}

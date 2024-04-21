package org.lab4.controller;

import org.lab4.jframe.JFrameObject;
import org.lab4.model.details.DetailsContext;
import org.lab4.model.details.ReadyCar;
import org.lab4.model.warehouse.ReadyCarWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Dealer implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Dealer.class);
    private boolean isLogging;

    private JFrameObject jFrameObject;
    private ReadyCarWarehouse readyCarWarehouse;
    private int sleepTime;

    public Dealer(boolean isLogging) {
        this.isLogging = isLogging;
    }

    public void setJFrameObject(JFrameObject jFrameObject) {
        this.jFrameObject = jFrameObject;
    }

    public void setReadyCarWarehouse(ReadyCarWarehouse readyCarWarehouse) {
        this.readyCarWarehouse = readyCarWarehouse;
    }

    @Override
    public void run() {
        while (true) {
            ReadyCar readyCar;
            try {
                readyCar = (ReadyCar) readyCarWarehouse.pickUpDetail();
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("Dealer: ", ex); }
                throw new RuntimeException(ex);
            }

            if (isLogging) {
                DetailsContext detailsContext = readyCar.getDetailsContext();
                log.info("Time: {}, Dealer {}, Auto: {}, (Body: {}, Engine: {}, Accessory: {}).", new Date(), 1, readyCar.getDetailId(),
                        detailsContext.getCarBody().getDetailId(), detailsContext.getEngine().getDetailId(), detailsContext.getAccessory().getDetailId());
            }

            sleepTime = jFrameObject.getDealersRequestDelay();
            try {
                sleep(sleepTime);
            } catch (InterruptedException ex) {
                if (isLogging) { log.error("Dealer with id: {}", 1, ex); }
                throw new RuntimeException(ex);
            }
        }
    }
}

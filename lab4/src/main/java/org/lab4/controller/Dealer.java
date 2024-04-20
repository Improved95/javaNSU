package org.lab4.controller;

import org.lab4.jframe.JFrameObject;
import org.lab4.model.warehouse.ReadyCarWarehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;

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
            try {
                readyCarWarehouse.pickUpDetail();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            if (isLogging) {
                log.info("Time: {}, Dealer {}, Auto: {}, (Body: {}, Engine: {}, Accessory: {}).", );
            }

            sleepTime = jFrameObject.getDealersRequestDelay();
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

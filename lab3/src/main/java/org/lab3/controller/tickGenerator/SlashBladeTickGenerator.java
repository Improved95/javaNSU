package org.lab3.controller.tickGenerator;

import org.lab3.controller.controller.Controller;
import org.lab3.controller.controller.SlashBladeController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlashBladeTickGenerator implements TickGenerator {
    private static final double maxFPS = 1;
    private static final double maxWaitingTime = 1000 / maxFPS;
    private static Controller slashBladeController;

    private static Timer generationTickTimer;
    private static TimerContext timerContext;

    public SlashBladeTickGenerator() {
        slashBladeController = new SlashBladeController();
        timerContext = new TimerContext();
    }

    public void initial() {
        generationTickTimer = new Timer((int)maxWaitingTime, new MyTaskActionListener());
        generationTickTimer.start();
    }

    class MyTaskActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createAndGetTimeCreateFrame(timerContext);
        }
    }

    private void createAndGetTimeCreateFrame(TimerContext timerContext) {
        timerContext.currentFrameTimeStart = System.currentTimeMillis();
        timerContext.currentFPS = 1000 / (timerContext.timeMakeFrame + maxWaitingTime);



        timerContext.currentFrameTimeEnd = System.currentTimeMillis();
        timerContext.timeMakeFrame = timerContext.currentFrameTimeEnd - timerContext.currentFrameTimeStart;
    }
}

class TimerContext {
    long currentFrameTimeStart = 0;
    long currentFrameTimeEnd = 0;
    long timeMakeFrame = 0;
    double currentFPS = 0;
}

package org.lab3.controller.controller;

import org.lab3.controller.logicController.LogicController;
import org.lab3.controller.logicController.SlashBladeLogicController;
import org.lab3.controller.keysListener.KeyListenerController;
import org.lab3.controller.keysListener.SlashBladeKeyListener;
import org.lab3.model.Model;
import org.lab3.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlashBladeController implements Controller {
    private final double maxFPS = 1;
    private final double maxWaitingTime = 1000 / maxFPS;

    private static LogicController slashBladeLogicController;
    private static KeyListenerController slashBladeKeyListenerController;

    private Model slashBladeModel;
    private View slashBladeView;

    private static Timer generationTickTimer;
    private static TimerContext timerContext;

    public SlashBladeController() {
        slashBladeLogicController = new SlashBladeLogicController();
        slashBladeKeyListenerController = new SlashBladeKeyListener();
        timerContext = new TimerContext();
    }

    public static LogicController getSlashBladeController() {
        return slashBladeLogicController;
    }

    public static KeyListenerController getSlashBladeKeyListenerController() {
        return slashBladeKeyListenerController;
    }

    @Override
    public void setSlashBladeModel(Model slashBladeModel) {
        this.slashBladeModel = slashBladeModel;
    }

    @Override
    public void setSlashBladeView(View slashBladeView) {
        this.slashBladeView = slashBladeView;
    }

    @Override
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

        slashBladeLogicController.calculateFrame();

        timerContext.currentFrameTimeEnd = System.currentTimeMillis();
        timerContext.timeMakeFrame = timerContext.currentFrameTimeEnd - timerContext.currentFrameTimeStart;
    }

    class TimerContext {
        long currentFrameTimeStart = 0;
        long currentFrameTimeEnd = 0;
        long timeMakeFrame = 0;
        double currentFPS = 0;
    }
}

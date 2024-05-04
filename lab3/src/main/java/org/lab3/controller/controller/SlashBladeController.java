package org.lab3.controller.controller;

import org.lab3.model.model.Model;
import org.lab3.model.Constants;
import org.lab3.view.swing.JFrameObject;
import org.lab3.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class SlashBladeController implements Controller {
    private final double maxFPS = 60;
    private final long maxWaitingTime = (long)(1000 / maxFPS);

    private SlashBladeLogicController slashBladeLogicController;
    private SlashBladeKeyListener slashBladeKeyListenerController;

    private JFrameObject jFrameObject;
    private Model model;
    private View view;

    private Timer generationTickTimer;
    private TimerContext timerContext;

    public SlashBladeController() {
        timerContext = new TimerContext();
        slashBladeLogicController = new SlashBladeLogicController();
        slashBladeKeyListenerController  = new SlashBladeKeyListener(slashBladeLogicController);
    }

    public SlashBladeLogicController getSlashBladeLogicController() {
        return slashBladeLogicController;
    }

    @Override
    public KeyListenerController getSlashBladeKeyListenerController() {
        return slashBladeKeyListenerController;
    }

    @Override
    public void setJFrameObject(JFrameObject jFrameObject) {
        this.jFrameObject = jFrameObject;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
        slashBladeKeyListenerController.setFrameSize(model.getFrameSize());
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void initial() {
        slashBladeLogicController.setModel(model);
        slashBladeLogicController.setView(view);
        slashBladeLogicController.initial();
        view.setDrawing(true);
        generationTickTimer = new Timer();
    }

    @Override
    public void executeCalculateGame() {
        generationTickTimer.scheduleAtFixedRate(new MyTask(), 0, maxWaitingTime);
    }

    class MyTask extends TimerTask {
        @Override
        public void run() {
            createAndGetTimeCreateFrame(timerContext);
        }
    }

    private void createAndGetTimeCreateFrame(TimerContext timerContext) {
        timerContext.createFrameTimeStart = System.currentTimeMillis();
        timerContext.timeMakeFrame = timerContext.createFrameTimeEnd - timerContext.createFrameTimeStart;
        timerContext.changeDelayBeforeCreateNextFrame();
        timerContext.currentFPS = 1000 / (timerContext.delayBeforeCreateNextFrame + timerContext.timeMakeFrame);

        /*-----------------*/

        int returnValue = slashBladeLogicController.calculateFrame(timerContext.currentFPS);
        view.changeViewScreen(jFrameObject);

        if (returnValue == Constants.GameConstants.EXIT_GAME) {
            generationTickTimer.cancel();
            jFrameObject.getJFrame().dispose();
        }

        /*-----------------*/


        timerContext.createFrameTimeEnd = System.currentTimeMillis();
    }

    private class TimerContext {
        long delayBeforeCreateNextFrame;
        long createFrameTimeStart = 0;
        long createFrameTimeEnd = 0;
        long timeMakeFrame = 0;
        double currentFPS = 0;

        public void changeDelayBeforeCreateNextFrame() {
            delayBeforeCreateNextFrame = maxWaitingTime - timeMakeFrame;
            if (delayBeforeCreateNextFrame < 0) {
                delayBeforeCreateNextFrame = 0;
            }
        }
    }
}

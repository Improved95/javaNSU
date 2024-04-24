package org.lab3.controller.controller;

import org.lab3.model.model.Model;
import org.lab3.slashBlade.JFrameObject;
import org.lab3.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class SlashBladeController implements Controller {
    private final double maxFPS = 60;
    private final long maxWaitingTime = (long)(1000 / maxFPS);

    private static SlashBladeLogicController slashBladeLogicController = new SlashBladeLogicController();
    private static SlashBladeKeyListener slashBladeKeyListenerController  = new SlashBladeKeyListener(slashBladeLogicController);

    private JFrameObject jFrameObject;
    private Model model;
    private View view;

    private Timer generationTickTimer;
    private TimerContext timerContext;

    public SlashBladeController() {
        timerContext = new TimerContext();
    }

    public static SlashBladeLogicController getSlashBladeController() {
        return slashBladeLogicController;
    }

    public static KeyListenerController getSlashBladeKeyListenerController() {
        return slashBladeKeyListenerController;
    }

    @Override
    public void setJFrameObject(JFrameObject jFrameObject) {
        this.jFrameObject = jFrameObject;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void initial() {
        slashBladeLogicController.setModel(model);
        slashBladeLogicController.setJFrameObject(jFrameObject);
        slashBladeLogicController.initial();
        view.setDrawing(true);
        generationTickTimer = new Timer();
    }

    /*надо бы придумать как уменьшить задержку в случае долгого создания кадра*/
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

        int returnValue = slashBladeLogicController.calculateFrame(timerContext.currentFPS, jFrameObject.getFrameSize());
        view.changeViewScreen(jFrameObject);

        if (returnValue == 1) {
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
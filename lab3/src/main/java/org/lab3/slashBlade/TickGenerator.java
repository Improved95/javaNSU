package org.lab3.slashBlade;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.controller.controller.SlashBladeKeyListener;
import org.lab3.controller.controller.SlashBladeLogicController;
import org.lab3.model.model.Model;
import org.lab3.view.FrameObject;
import org.lab3.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class TickGenerator {
    private final double maxFPS = 60;
    private final long maxWaitingTime = (long)(1000 / maxFPS);

    private SlashBladeLogicController slashBladeLogicController;
    private SlashBladeKeyListener slashBladeKeyListenerController;

    private FrameObject swingFrame;
    private FrameObject javaFxFrame;

    private View swingView;
    private View javaFxView;

    private Model model;

    private Timer generationTickTimer;
    private TimerContext timerContext;

    public TickGenerator() {
        timerContext = new TimerContext();
        slashBladeLogicController = new SlashBladeLogicController();
        slashBladeKeyListenerController  = new SlashBladeKeyListener(slashBladeLogicController);
    }

    public SlashBladeLogicController getSlashBladeLogicController() {
        return slashBladeLogicController;
    }

    public KeyListenerController getSlashBladeKeyListenerController() {
        return slashBladeKeyListenerController;
    }

    public void setSwingFrame(FrameObject frameObject) {
        this.swingFrame = frameObject;
    }

    public void setJavaFxFrame(FrameObject javaFxFrame) {
        this.javaFxFrame = javaFxFrame;
    }

    public void setModel(Model model) {
        this.model = model;
        slashBladeKeyListenerController.setFrameSize(model.getFrameSize());
    }

    public void setSwingView(View view) {
        this.swingView = view;
    }
    public void setJavaFxView(View view) {
        this.javaFxView = view;
    }

    public void initial() {
        slashBladeLogicController.setModel(model);
//        slashBladeLogicController.setSwingView(swingView);
        slashBladeLogicController.setJavaFxView(javaFxView);
        slashBladeLogicController.initial();

//        swingView.setDrawing(true);
        javaFxView.setDrawing(false);

        generationTickTimer = new Timer();
    }

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
//        swingView.changeViewScreen(swingFrame);
        javaFxView.changeViewScreen(javaFxFrame);

        if (returnValue == Constants.GameConstants.EXIT_GAME) {
            generationTickTimer.cancel();
//            swingFrame.getJFrame().dispose();
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

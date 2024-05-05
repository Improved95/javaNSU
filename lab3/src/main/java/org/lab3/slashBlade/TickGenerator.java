package org.lab3.slashBlade;

import org.lab3.controller.controller.KeyListenerController;
import org.lab3.controller.controller.SlashBladeKeyListener;
import org.lab3.controller.controller.SlashBladeLogicController;
import org.lab3.model.model.Model;
import org.lab3.view.javaFx.JavaFxFrame;
import org.lab3.view.swing.SwingFrame;

import java.util.Timer;
import java.util.TimerTask;

import static org.lab3.slashBlade.Constants.ViewConstants.definitionForJavaFx;
import static org.lab3.slashBlade.Constants.ViewConstants.definitionForSwing;

public class TickGenerator {
    private final double maxFPS = 60;
    private final long maxWaitingTime = (long)(1000 / maxFPS);

    private SlashBladeLogicController slashBladeLogicController;
    private SlashBladeKeyListener slashBladeKeyListenerController;

    private SwingFrame swingFrame;
    private JavaFxFrame javaFxFrame;

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

    public void setSwingFrame(SwingFrame swingFrame) {
        this.swingFrame = swingFrame;
    }

    public void setJavaFxFrame(JavaFxFrame javaFxFrame) {
        this.javaFxFrame = javaFxFrame;
    }

    public void setModel(Model model) {
        this.model = model;
        slashBladeKeyListenerController.setFrameSize(model.getFrameSize());
    }

    public void initial() {
        slashBladeLogicController.setModel(model);

        if (definitionForSwing()) slashBladeLogicController.setSwingView(swingFrame.getView());
        if (definitionForJavaFx()) slashBladeLogicController.setJavaFxView(JavaFxFrame.getView());

        slashBladeLogicController.initial();

        if (definitionForSwing()) swingFrame.setDrawing(true);
        if (definitionForJavaFx()) javaFxFrame.setDrawing(true);

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

        if (definitionForSwing()) swingFrame.repaint();
        if (definitionForJavaFx()) javaFxFrame.
//        if (definitionForJavaFx()) javaFxFrame.repaint();

        if (returnValue == Constants.GameConstants.EXIT_GAME) {
            generationTickTimer.cancel();
            if (definitionForSwing()) swingFrame.close();
            if (definitionForJavaFx()) JavaFxFrame.close();
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

package org.lab3.slashBlade;

import javafx.application.Platform;
import org.lab3.controller.controller.KeyListenerController;
import org.lab3.controller.controller.SlashBladeKeyListener;
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

    private LogicController logicController;
    private SlashBladeKeyListener slashBladeKeyListenerController;

    private SwingFrame swingFrame;
    private JavaFxFrame javaFxFrame;

    private Model model;

    private Timer generationTickTimer;
    private TimerContext timerContext;

    public TickGenerator() {
        timerContext = new TimerContext();
        logicController = new LogicController();
        slashBladeKeyListenerController  = new SlashBladeKeyListener(logicController);
    }

    public LogicController getSlashBladeLogicController() {
        return logicController;
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
        logicController.setModel(model);

        if (definitionForSwing()) logicController.setSwingView(swingFrame.getView());
        if (definitionForJavaFx()) logicController.setJavaFxView(JavaFxFrame.getView());

        logicController.initial();

        if (definitionForSwing()) swingFrame.setDrawing();
        if (definitionForJavaFx()) Platform.runLater(() -> javaFxFrame.setDrawing());

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

        int returnValue = logicController.calculateFrame(timerContext.currentFPS);

        if (definitionForSwing()) swingFrame.repaint();
        if (definitionForJavaFx()) Platform.runLater(() -> javaFxFrame.repaint());

        if (returnValue == Constants.GameConstants.EXIT_GAME) {
            generationTickTimer.cancel();
            if (definitionForSwing()) swingFrame.close();

            if (definitionForJavaFx()) Platform.runLater(() -> javaFxFrame.close());
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

package org.lab3.controller.controller;

import com.sun.source.util.TaskListener;
import org.lab3.model.model.Model;
import org.lab3.slashBlade.JFrameObject;
import org.lab3.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        slashBladeLogicController.initial();
        generationTickTimer = new Timer();
    }

    /*надо бы придумать как уменьшить задержку в случае долгого создания кадра,
    * а может и не надо*/
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
        timerContext.currentFrameTimeStart = System.currentTimeMillis();
        timerContext.currentFPS = 1000 / (timerContext.timeMakeFrame + maxWaitingTime);

        slashBladeLogicController.calculateFrame(timerContext.currentFPS, jFrameObject.getFrameSize());
        view.changeViewScreen(jFrameObject);

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

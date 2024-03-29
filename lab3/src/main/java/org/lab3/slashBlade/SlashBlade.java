package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.controller.SlashBladeController;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

import java.lang.reflect.InvocationTargetException;

public class SlashBlade {
    private JFrameObject jFrameSlashBlade;
    private Controller slashBladeController = null;
    private Model slashBladeModel = null;
    private View slashBladeView = null;

    public SlashBlade() {
        initial();
    }

    public void play() {
        TickGenerator tickGenerator = new TickGenerator();
        long currentFrameTimeStart;
        long currentFrameTimeEnd;
        long makeFrameTime = 0;
        double currentFPS;

        while(true) {
            if (tickGenerator.isGenerateNext(makeFrameTime)) {
                currentFrameTimeStart = System.currentTimeMillis();

                currentFPS = 1000 / (makeFrameTime + tickGenerator.getMaxWaitingTime());
                slashBladeModel.changeModel(currentFPS, jFrameSlashBlade.getFrameSize());
                slashBladeView.changeViewScreen(jFrameSlashBlade);

                currentFrameTimeEnd = System.currentTimeMillis();
                makeFrameTime = currentFrameTimeEnd - currentFrameTimeStart;
            }
        }
    }

    private class TickGenerator {
        private final double maxFPS = 60;
        private final double maxWaitingTime = 1000 / maxFPS;

        private long nowTime;
        private long lastTime = System.currentTimeMillis();

        public double getMaxWaitingTime() {
            return maxWaitingTime;
        }

        public boolean isGenerateNext(long makeFrameTime) {
            nowTime = System.currentTimeMillis();
            if (nowTime - lastTime >= maxWaitingTime - makeFrameTime) {
                lastTime = nowTime;
                return true;
            }
            return false;
        }
    }

    private void initial() {
        try {
            slashBladeController = new SlashBladeController();
            slashBladeModel = new SlashBladeModel();
            slashBladeView = new SlashBladeView();
        } catch (ClassNotFoundException | InvocationTargetException |
                 InstantiationException | IllegalAccessException | NoSuchMethodException ex) {

            ex.printStackTrace();
        }

        slashBladeController.registerObserver(slashBladeModel);
        slashBladeModel.registerObserver(slashBladeView);

        jFrameSlashBlade = new JFrameSlashBlade(1500);
        jFrameSlashBlade.addDrawableComponent(slashBladeView, slashBladeController);
        slashBladeModel.initial();
    }
}

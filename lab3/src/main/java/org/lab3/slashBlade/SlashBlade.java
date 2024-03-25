package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.controller.SlashBladeController;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

import static java.lang.Thread.sleep;

public class SlashBlade {
    private JFrameSlashBlade jFrameSlashBlade;
    private Controller slashBladeController = null;
    private Model slashBladeModel = null;
    private View slashBladeView = null;

    public SlashBlade() {
        initial();
    }

    public void play() {
        TickGenerator tickGenerator = new TickGenerator();
        long currentFrameTimeStart = 0;
        long currentFrameTimeEnd = 0;

//        while(true) {
//            if (tickGenerator.isGenerateNext(currentFrameTimeEnd - currentFrameTimeStart)) {
//                currentFrameTimeStart = System.currentTimeMillis();
//
//                slashBladeModel.change();
//
//                currentFrameTimeEnd = System.currentTimeMillis();
//            }
//        }

        slashBladeModel.changeModel(jFrameSlashBlade);

        try {
            sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        slashBladeModel.changeModel(jFrameSlashBlade);
    }

    private class TickGenerator {
        private final double maxFPS = 1;
        private final double maxWaitingTime = 1000 / maxFPS;

        public long nowTime;
        public long lastTime = System.currentTimeMillis();

        public boolean isGenerateNext(long frameTime) {
            nowTime = System.currentTimeMillis();
            if (nowTime - lastTime >= maxWaitingTime - frameTime) {
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
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException ex) {
            ex.printStackTrace();
        }

        slashBladeController.registerObserver(slashBladeModel);
        slashBladeModel.registerObserver(slashBladeView);

        jFrameSlashBlade = new JFrameSlashBlade(1920, slashBladeController);
        jFrameSlashBlade.addDrawableComponent(slashBladeView);
    }
}

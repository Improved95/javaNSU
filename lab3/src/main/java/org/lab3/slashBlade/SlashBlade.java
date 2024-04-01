package org.lab3.slashBlade;

import org.lab3.controller.keysListener.KeyListenerController;
import org.lab3.controller.tickGenerator.SlashBladeTickGenerator;
import org.lab3.controller.keysListener.SlashBladeKeyListener;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

import java.lang.reflect.InvocationTargetException;

public class SlashBlade {
    private JFrameObject jFrameSlashBlade;
    private Model slashBladeModel = null;
    private View slashBladeView = null;

    public SlashBlade() {
        initial();
    }

   /* public void play() {
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
    }*/

    private void initial() {
        try {
            slashBladeKeyListenerController = new SlashBladeKeyListener();
            slashBladeModel = new SlashBladeModel();
            slashBladeView = new SlashBladeView();
        } catch (ClassNotFoundException | InvocationTargetException |
                 InstantiationException | IllegalAccessException | NoSuchMethodException ex) {

            ex.printStackTrace();
        }

        slashBladeKeyListenerController.registerObserver(slashBladeModel);
        slashBladeModel.registerObserver(slashBladeView);

        jFrameSlashBlade = new JFrameSlashBlade(1500);
        jFrameSlashBlade.addDrawableComponent(slashBladeView, slashBladeKeyListenerController);
        slashBladeModel.initial();
    }
}

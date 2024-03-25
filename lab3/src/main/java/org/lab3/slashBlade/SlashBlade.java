package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.controller.SlashBladeController;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

public class SlashBlade {
    private JFrameObject jFrameObject;
    private Controller slashBladeController = null;
    private Model slashBladeModel = null;
    private View slashBladeView = null;

    public SlashBlade() {
        initial();
    }

    public void play() {
        long nowTime = System.currentTimeMillis();
        int FPS = 60;

        while(true) {



        }

        slashBladeModel.change();
        try {
            slashBladeView.change(slashBladeModel, jFrameObject);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
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

        jFrameObject = new JFrameObject(1920, slashBladeController);
        jFrameObject.addDrawableComponent((SlashBladeView) slashBladeView);
    }
}

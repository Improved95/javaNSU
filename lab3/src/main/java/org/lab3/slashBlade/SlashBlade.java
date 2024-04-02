package org.lab3.slashBlade;

import org.lab3.controller.controller.SlashBladeController;
import org.lab3.controller.controller.Controller;
import org.lab3.model.model.Model;
import org.lab3.model.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

public class SlashBlade {
    private static JFrameObject jFrameSlashBlade;
    private static Model slashBladeModel = null;
    private static View slashBladeView = null;
    private static Controller slashBladeController = null;

    public SlashBlade() {
        initialSlashBlade();
    }

    private static void initialSlashBlade() {
        slashBladeController = new SlashBladeController();
        slashBladeModel = new SlashBladeModel();
        slashBladeView = new SlashBladeView();

        slashBladeView.setModel(slashBladeModel);

        slashBladeController.setModel(slashBladeModel);
        slashBladeController.setView(slashBladeView);
        slashBladeController.initial();

        jFrameSlashBlade = new JFrameSlashBlade(1500);
        jFrameSlashBlade.addDrawableComponent(slashBladeView, SlashBladeController.getSlashBladeKeyListenerController());

        slashBladeController.setJFrameObject(jFrameSlashBlade);

        slashBladeController.executeCalculateGame();
    }
}

package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.controller.SlashBladeController;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

public class SlashBlade {
    private JFrameObject jFrameObject;

    public SlashBlade() {
        this.jFrameObject = new JFrameObject(1920);
        jFrameObject.addObjectsOnFrame(null);
    }

    public void initial() {
        Controller slashBladeController = null;
        Model slashBladeModel = null;
        View slashBladeView = null;

        try {
            slashBladeController = new SlashBladeController();
            slashBladeModel = new SlashBladeModel(slashBladeController);
            slashBladeView = new SlashBladeView(slashBladeModel);
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }
}

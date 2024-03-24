package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.controller.SlashBladeController;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

public class SlashBlade {
    private JFrameObject jFrameObject;

    public void initial() {
        Controller slashBladeController = null;
        Model slashBladeModel = null;
        View slashBladeView = null;


        try {
            slashBladeController = new SlashBladeController();
            slashBladeModel = new SlashBladeModel();
            slashBladeView = new SlashBladeView();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException ex) {
            ex.printStackTrace();
        }

        slashBladeController.registerObserver(slashBladeModel);
        slashBladeModel.registerObserver(slashBladeView);

        this.jFrameObject = new JFrameObject(1920);
        while (true) {
            slashBladeController.readInput();
            try {
                slashBladeView.change(slashBladeModel, jFrameObject);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
    }
}

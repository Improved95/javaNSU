package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.controller.SlashBladeController;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

public class SlashBlade {
    public static void initial() {
        Controller slashBladeController = null;
        Model slashBladeModel = null;
        View slashBladeView = null;

        try {
            slashBladeController = new SlashBladeController();
            slashBladeModel = new SlashBladeModel();
            slashBladeView = new SlashBladeView(1920);
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException ex) {
            ex.printStackTrace();
        }

        try {
            while (true) {
                slashBladeController.readInput();
                slashBladeModel.changeModel(slashBladeController);
                slashBladeView.change(slashBladeModel);
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
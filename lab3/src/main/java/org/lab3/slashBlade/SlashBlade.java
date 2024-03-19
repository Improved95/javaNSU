package org.lab3.slashBlade;

import org.lab3.controller.Controller;
import org.lab3.controller.SlashBladeController;
import org.lab3.model.Model;
import org.lab3.model.SlashBladeModel;
import org.lab3.resources.ResourcesContext;
import org.lab3.view.SlashBladeView;
import org.lab3.view.View;

public class SlashBlade {
    public static void initial(ResourcesContext resourcesContext) {
        Controller slashBladeController = new SlashBladeController();
        Model slashBladeModel = new SlashBladeModel();
        View slashBladeView = new SlashBladeView(1500);

        while (true) {
            slashBladeController.readInput();
            slashBladeModel.changeModel();
            slashBladeView.change();
        }
    }


}

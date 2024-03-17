package org.lab3.slashBlade;

import org.lab3.model.Model;
import org.lab3.controller.Controller;
import org.lab3.view.View;

public class SlashBlade {
    public static void initial() {
//        Controller gameController = new Controller();
//        Model gameModel = new Model();
        View gameView = new View(1500);

        while (true) {
            gameView.change();
        }
    }
}

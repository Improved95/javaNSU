package org.lab3.slashBlade;

import org.lab3.model.view.View;

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

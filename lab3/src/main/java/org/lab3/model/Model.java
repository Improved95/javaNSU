package org.lab3.model;

import org.lab3.controller.Controller;
import org.lab3.model.gameMode.GameMode;

public interface Model {
    void changeModel(Controller controller);
    GameMode getCurrentGameMode();
}

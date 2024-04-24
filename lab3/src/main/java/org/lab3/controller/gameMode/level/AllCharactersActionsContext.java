package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.SlashFX.SlashFXController;
import org.lab3.controller.actions.enemyActions.EnemyAction;
import org.lab3.controller.actions.playerActions.PlayerAction;

import java.util.ArrayList;
import java.util.List;

public class AllCharactersActionsContext {
    private PlayerAction playerActionController;
    private List<EnemyAction> enemyActionsControllers = new ArrayList<>();
    private SlashFXController slashFXController;

    public PlayerAction getPlayerActionController() {
        return playerActionController;
    }

    public void setPlayerActionController(PlayerAction playerActionController) {
        this.playerActionController = playerActionController;
    }

    public List<EnemyAction> getEnemyActionsControllers() {
        return enemyActionsControllers;
    }

    public SlashFXController getSlashFXController() {
        return slashFXController;
    }

    public void setSlashFXController(SlashFXController slashFXController) {
        this.slashFXController = slashFXController;
    }
}

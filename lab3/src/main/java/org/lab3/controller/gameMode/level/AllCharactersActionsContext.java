package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.enemyActions.EnemyAction;
import org.lab3.controller.actions.playerActions.PlayerAction;

import java.util.ArrayList;
import java.util.List;

public class AllCharactersActionsContext {
    private PlayerAction playerActionController;
    private List<EnemyAction> enemyActionsControllers = new ArrayList<>();

    public PlayerAction getPlayerActionController() {
        return playerActionController;
    }

    public void setPlayerActionController(PlayerAction playerActionController) {
        this.playerActionController = playerActionController;
    }

    public List<EnemyAction> getEnemyActionsControllers() {
        return enemyActionsControllers;
    }
}

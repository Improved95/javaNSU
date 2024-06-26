package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.enemyActions.EnemyAction;
import org.lab3.controller.actions.pause.EndGameMenuAction;
import org.lab3.controller.actions.pause.PauseAction;
import org.lab3.controller.actions.playerActions.PlayerAction;

import java.util.List;

public class AllCharactersActionsContext {
    private PlayerAction playerActionController;
    private List<EnemyAction> enemyActionsControllers;
    private PauseAction pauseAction;
    private EndGameMenuAction endGameMenuAction;

    public PlayerAction getPlayerActionController() {
        return playerActionController;
    }

    public void setPlayerActionController(PlayerAction playerActionController) {
        this.playerActionController = playerActionController;
    }

    public List<EnemyAction> getEnemyActionsControllers() {
        return enemyActionsControllers;
    }

    public void setEnemyActionsControllers(List<EnemyAction> enemyActionsControllers) {
        this.enemyActionsControllers = enemyActionsControllers;
    }

    public PauseAction getPauseAction() {
        return pauseAction;
    }

    public void setPauseAction(PauseAction pauseAction) {
        this.pauseAction = pauseAction;
    }

    public EndGameMenuAction getEndGameMenuAction() {
        return endGameMenuAction;
    }

    public void setEndGameMenuAction(EndGameMenuAction endGameMenuAction) {
        this.endGameMenuAction = endGameMenuAction;
    }
}

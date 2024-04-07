package org.lab3.controller.actions;

import org.lab3.controller.actions.enemyActions.EnemyActionAbstract;
import org.lab3.controller.actions.samuraiActions.PlayerActionAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllCharactersActionsContext {
    private Map<String, PlayerActionAbstract> playerMovement;
    private List<Map<String, EnemyActionAbstract>> enemyMovementList = new ArrayList<>();

    public Map<String, PlayerActionAbstract> getPlayerMovement() {
        return playerMovement;
    }

    public void setPlayerMovement(Map<String, PlayerActionAbstract> playerMovement) {
        this.playerMovement = playerMovement;
    }

    public List<Map<String, EnemyActionAbstract>> getEnemyMovementList() {
        return enemyMovementList;
    }

    public void setEnemyMovementList(List<Map<String, EnemyActionAbstract>> enemyMovementList) {
        this.enemyMovementList = enemyMovementList;
    }
}

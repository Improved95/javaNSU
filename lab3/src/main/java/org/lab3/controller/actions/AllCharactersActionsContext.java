package org.lab3.controller.actions;

import org.lab3.controller.actions.enemyActions.EnemyActionAbstract;
import org.lab3.controller.actions.samuraiActions.PlayerActionAbstract;
import org.lab3.controller.gameMode.level.ObjectAndHisMovement;
import org.lab3.model.objects.characters.SamuraiV1;

import java.util.ArrayList;
import java.util.List;

public class AllCharactersActionsContext {
    private ObjectAndHisMovement<SamuraiV1, PlayerActionAbstract> playerMovement;
    private List<ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract>> enemyMovementList = new ArrayList<>();

    public ObjectAndHisMovement<SamuraiV1, PlayerActionAbstract> getPlayerMovement() {
        return playerMovement;
    }

    public void setPlayerMovement(ObjectAndHisMovement<SamuraiV1, PlayerActionAbstract> playerMovement) {
        this.playerMovement = playerMovement;
    }

    public List<ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract>> getEnemyMovementList() {
        return enemyMovementList;
    }

    public void setEnemyMovementList(List<ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract>> enemyMovementList) {
        this.enemyMovementList = enemyMovementList;
    }
}

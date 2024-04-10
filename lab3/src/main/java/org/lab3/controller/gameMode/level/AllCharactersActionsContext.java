package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.ObjectAndHisMovement;
import org.lab3.controller.actions.enemyActions.EnemyActionAbstract;
import org.lab3.controller.actions.samuraiActions.PlayerActionAbstract;
import org.lab3.model.objects.characters.SamuraiV1;

import java.util.ArrayList;
import java.util.List;

public class AllCharactersActionsContext {
    private ObjectAndHisMovement<SamuraiV1, PlayerActionAbstract> playerAndMovement = new ObjectAndHisMovement<>();
    private List<ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract>> enemyAndMovementList = new ArrayList<>();

    public ObjectAndHisMovement<SamuraiV1, PlayerActionAbstract> getPlayerAndMovement() {
        return playerAndMovement;
    }

    public void setPlayerAndMovement(ObjectAndHisMovement<SamuraiV1, PlayerActionAbstract> playerAndMovement) {
        this.playerAndMovement = playerAndMovement;
    }

    public List<ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract>> getEnemyAndMovementList() {
        return enemyAndMovementList;
    }

    public void setEnemyAndMovementList(List<ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract>> enemyAndMovementList) {
        this.enemyAndMovementList = enemyAndMovementList;
    }
}

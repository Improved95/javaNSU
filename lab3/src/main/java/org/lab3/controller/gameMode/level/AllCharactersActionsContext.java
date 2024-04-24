package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.ObjectAndHisMovement;
import org.lab3.controller.actions.playerActions.PlayerAction;
import org.lab3.model.objects.characters.SamuraiV1;

public class AllCharactersActionsContext {
    private ObjectAndHisMovement<SamuraiV1, PlayerAction> playerAndMovement = new ObjectAndHisMovement<>();
//    private List<ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract>> enemyAndMovementList = new ArrayList<>();

    public ObjectAndHisMovement<SamuraiV1, PlayerAction> getPlayerAndMovement() {
        return playerAndMovement;
    }
}

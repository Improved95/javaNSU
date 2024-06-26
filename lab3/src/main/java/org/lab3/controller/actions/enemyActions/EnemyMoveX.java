package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;

public class EnemyMoveX extends ActionExecuteAbstract {
    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext, double currentFPS) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            double playerPosX = player.getInGamePosX();
            double enemyPosX = character.getInGamePosX();
            double enemySpeed = character.getSpeedOfMoveX();
            if (Math.abs(enemyPosX - playerPosX) > 30) {
                if (enemyPosX - playerPosX < 0) {
                    character.changeDirection(1);
                    character.setCurrentSpeedX(enemySpeed / currentFPS);
                } else {
                    character.changeDirection(-1);
                    character.setCurrentSpeedX(enemySpeed / currentFPS * -1);
                }
            } else {
                character.setCurrentSpeedX(0);
            }
        }
    }
}

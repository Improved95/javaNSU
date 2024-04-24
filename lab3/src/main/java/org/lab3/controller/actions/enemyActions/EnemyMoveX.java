package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.slashBlade.FrameSize;

public class EnemyMoveX extends ActionExecuteAbstract {
    public EnemyMoveX() {
        this.isExecute = true;
    }

    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext, double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            double playerPosX = player.getInGamePosX();
            double enemyPosX = character.getInGamePosX();
            double enemySpeed = character.getParametersContext().getSpeedOfMoveX();
            double dx;
            if (Math.abs(enemyPosX - playerPosX) > 30) {
                if (enemyPosX - playerPosX < 0) {
                    character.changeDirection(1);
                    dx = enemySpeed / currentFPS * frameSize.getReductionFactor();
                } else {
                    character.changeDirection(-1);
                    dx = enemySpeed / currentFPS * frameSize.getReductionFactor() * -1;
                }
                character.changeInGamePos(dx, 0);
            }
        }
    }
}

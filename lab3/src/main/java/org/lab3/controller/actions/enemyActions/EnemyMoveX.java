package org.lab3.controller.actions.enemyActions;

import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.slashBlade.FrameSize;

import java.util.Set;

public class EnemyMoveX extends EnemyActionAbstract {
    public EnemyMoveX(Set<SamuraiV1> enemyList) {
        super(enemyList);
        this.isExecute = true;
    }

    @Override
    public void execute(LevelObjectsContext levelObjectsContext, double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            double playerPosX = player.getInGamePosX();
            for (SamuraiV1 enemy : enemyList) {
                double enemyPosX = enemy.getInGamePosX();
                double enemySpeed = enemy.getParametersContext().getSpeedOfMoveX();
                double dx;
                if (Math.abs(enemyPosX - playerPosX) > 30) {
                    if (enemyPosX - playerPosX < 0) {
                        enemy.changeDirection(1);
                        dx = enemySpeed / currentFPS * frameSize.getReductionFactor();
                    } else {
                        enemy.changeDirection(-1);
                        dx = enemySpeed / currentFPS * frameSize.getReductionFactor() * -1;
                    }
                    enemy.changeInGamePos(dx, 0);
                }
            }
        }
    }
}

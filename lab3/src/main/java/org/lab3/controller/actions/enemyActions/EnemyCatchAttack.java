package org.lab3.controller.actions.enemyActions;

import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.slashBlade.FrameSize;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnemyCatchAttack extends EnemyActionAbstract {

    public EnemyCatchAttack(List<SamuraiV1> enemyList) {
        super(enemyList);
        this.isExecute = true;
    }

    @Override
    public void execute(LevelObjectsContext levelObjectsContext, double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {

            Set<SamuraiV1> deleteEnemySet = new HashSet<>();

            for (SamuraiV1 enemy : enemyList) {
                catchPlayerAttack(enemy, levelObjectsContext, deleteEnemySet);
            }

            levelObjectsContext.getEnemyList().removeAll(deleteEnemySet);

        }
    }

    private void catchPlayerAttack(SamuraiV1 enemy, LevelObjectsContext levelObjectsContext, Set<SamuraiV1> deleteEnemySet) {
        SamuraiV1 player = levelObjectsContext.getPlayer();
        if (player.getParametersContext().isAttack()) {
            double relativePos = enemy.getInGamePosX() - player.getInGamePosX();
            double radiusForwardAttack = player.getParametersContext().getRadiusForwardAttack();
            double radiusBackwardAttack = player.getParametersContext().getRadiusBackwardAttack();

            if (player.getParametersContext().getInGameHorizontalDirection() == 1) {
                if (relativePos <= radiusForwardAttack && relativePos >= -radiusBackwardAttack) {
                    deleteEnemySet.add(enemy);
                    System.out.println(player.getInGamePosX() + " " + enemy.getInGamePosX());
                }
            } else {
                if (relativePos >= -radiusForwardAttack && relativePos <= radiusBackwardAttack) {
                    deleteEnemySet.add(enemy);
                }
            }
        }
    }
}

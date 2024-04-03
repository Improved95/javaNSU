package org.lab3.controller.actions.enemyActions;

import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.slashBlade.FrameSize;

import java.util.ArrayList;
import java.util.List;

public class EnemyCatchAttack extends EnemyActionAbstract {
    private double radiusForwardAttack = 100;
    private double radiusBackwardAttack = 10;

    public EnemyCatchAttack(List<SamuraiV1> enemyList) {
        super(enemyList);
        this.isExecute = true;
    }

    @Override
    public void execute(LevelObjectsContext levelObjectsContext, double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            if (player.getParametersContext().isAttack()) {

                List<SamuraiV1> deleteEnemyList = new ArrayList<>();

                for (SamuraiV1 enemy : enemyList) {
                    double relativePos = player.getInGamePosX() - enemy.getInGamePosX();
                    if (player.getParametersContext().getInGameHorizontalDirection() == 1) {
                        if ((relativePos <= radiusForwardAttack && relativePos >= 0) || (relativePos >= -radiusBackwardAttack &&  relativePos <=  0)) {
                            deleteEnemyList.add(enemy);
                            System.out.println(player.getInGamePosX() + " " + enemy.getInGamePosX());
                        }
                    } else {
                        if (() || ()) {
                            deleteEnemyList.add(enemy);
                        }
                    }
                }

                levelObjectsContext.getEnemyList().removeAll(deleteEnemyList);

            }
        }
    }
}

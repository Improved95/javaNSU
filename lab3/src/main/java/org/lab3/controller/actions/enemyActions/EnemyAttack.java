package org.lab3.controller.actions.enemyActions;

import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.slashBlade.FrameSize;

import java.util.List;

public class EnemyAttack extends EnemyActionAbstract {
    private double attackDuration;
    private double attackDelay;

    public EnemyAttack(List<SamuraiV1> enemyList) {
        super(enemyList);
        this.isExecute = true;
    }

    @Override
    public void execute(LevelObjectsContext levelObjectsContext, double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
            SamuraiV1 player = levelObjectsContext.getPlayer();
            double playerPosX = player.getInGamePosX();
            for (SamuraiV1 enemy : enemyList) {
                double relativePos = Math.abs(enemy.getInGamePosX() - player.getInGamePosX());
                if (relativePos < 80) {

                }
            }
        }
    }
}

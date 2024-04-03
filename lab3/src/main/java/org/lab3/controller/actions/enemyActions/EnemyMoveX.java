package org.lab3.controller.actions.enemyActions;

import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.slashBlade.FrameSize;

import java.util.List;

public class EnemyMoveX extends EnemyActionAbstract {
    public EnemyMoveX(List<SamuraiV1> enemyList) {
        super(enemyList);
    }

    @Override
    public void execute(SamuraiV1 player, double currentFPS, FrameSize frameSize) {
        for (SamuraiV1 enemy : enemyList) {

        }
    }
}

package org.lab3.controller.actions.enemyActions;

import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.slashBlade.FrameSize;

import java.util.List;

public abstract class EnemyActionAbstract {
    protected boolean isExecute = false;
    protected boolean isBlockExecute = false;

    protected List<SamuraiV1> enemyList;

    public EnemyActionAbstract(List<SamuraiV1> enemyList) {
        this.enemyList = enemyList;
    }

    public void setExecuteStatus(boolean isExecute) {
        this.isExecute = isExecute;
    }

    public void setBlockExecuteStatus(boolean isBlockExecute) {
        this.isBlockExecute = isBlockExecute;
    }

    public abstract void execute(SamuraiV1 player, double currentFPS, FrameSize frameSize);
}

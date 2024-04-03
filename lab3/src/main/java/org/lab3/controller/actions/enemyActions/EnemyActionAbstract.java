package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionControllerAbstract;
import org.lab3.model.objects.characters.SamuraiV1;
import java.util.List;

public abstract class EnemyActionAbstract extends ActionControllerAbstract {
    protected List<SamuraiV1> enemyList;

    public EnemyActionAbstract(List<SamuraiV1> enemyList) {
        this.enemyList = enemyList;
    }
}

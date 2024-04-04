package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionControllerAbstract;
import org.lab3.model.objects.characters.SamuraiV1;
import java.util.Set;

public abstract class EnemyActionAbstract extends ActionControllerAbstract {
    protected Set<SamuraiV1> enemyList;

    public EnemyActionAbstract(Set<SamuraiV1> enemyList) {
        this.enemyList = enemyList;
    }
}

package org.lab3.controller.actions.enemyActions;

import org.lab3.model.objects.characters.SamuraiV1;

import java.util.List;

public class EnemyActionAbstract {
    private List<SamuraiV1> enemyList;

    public EnemyActionAbstract(List<SamuraiV1> enemyList) {
        this.enemyList = enemyList;
    }

    public void attack() {}
    public void changeMoveX() {}
}

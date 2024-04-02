package org.lab3.controller.gameMode.level;

import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.resources.ResourcesContext;

import java.util.List;

public class EnemyCreator {
    private double createDelay;
    private double timerCreateDelay = createDelay;

    public double getCreateDelay() {
        return createDelay;
    }

    public void setCreateDelay(double createDelay) {
        this.createDelay = createDelay;
        timerCreateDelay = createDelay;
    }

    public SamuraiV1 create(List<SamuraiV1> enemyList, ResourcesContext enemyImagesResources, double currentFPS) {
        if (timerCreateDelay <= 0) {
            SamuraiV1 enemy = new SamuraiV1();
            enemy.setScreenLayerLevel(1);
            enemy.getParametersContext().setHealth(1);
            enemy.setScreenSize(90);
            enemy.setInGamePosition(500, 0);
            enemy.setImage(enemyImagesResources.getOpenedResourcesList().get(0).getOpenedImage());
            enemyList.add(enemy);
            timerCreateDelay = createDelay;
            return enemy;
        } else {
            timerCreateDelay -= 1000 / currentFPS;
            return null;
        }
    }
}
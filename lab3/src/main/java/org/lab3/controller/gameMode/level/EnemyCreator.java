package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.enemyActions.EnemyActionAbstract;
import org.lab3.controller.actions.enemyActions.EnemyCatchAttack;
import org.lab3.controller.actions.enemyActions.EnemyMoveX;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.resources.ResourcesContext;
import org.lab3.slashBlade.FrameSize;

import java.util.List;
import java.util.Random;

public class EnemyCreator {
    private double createDelay;
    private double timerCreateDelay = createDelay;

    public void setCreateDelay(double createDelay) {
        this.createDelay = createDelay;
        timerCreateDelay = createDelay;
    }

    public void create(List<SamuraiV1> enemyList, List<ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract>> enemyMovementList,
                       ResourcesContext enemyImagesResources, FrameSize frameSize, double currentFPS) {

        if (timerCreateDelay <= 0) {
            SamuraiV1 enemy = new SamuraiV1();
            enemy.setScreenLayerLevel(1);
            enemy.getParametersContext().setSpeedOfMoveX(500);

            Random random = new Random();
            if (random.nextInt() % 2 == 1) {
                enemy.setInGamePosition(-100, 0);
                enemy.changeDirection(1);
            } else {
                enemy.setInGamePosition(frameSize.getWidth() + 100, 0);
                enemy.changeDirection(-1);
            }

            enemy.setImage(enemyImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

            ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract> enemyMovement = new ObjectAndHisMovement<>(enemy);
            fillEnemyMovement(enemyMovement, enemy);
            enemyMovementList.add(enemyMovement);
            enemyList.add(enemy);

            timerCreateDelay = createDelay;
        } else {
            timerCreateDelay -= 1000 / currentFPS;
        }
    }

    private void fillEnemyMovement(ObjectAndHisMovement<SamuraiV1, EnemyActionAbstract> enemyMovement, SamuraiV1 enemy) {
        enemyMovement.getActionControllers().put("ENEMY_MOVE_X", new EnemyMoveX(enemy));
        enemyMovement.getActionControllers().put("ENEMY_CATCH_ATTACK", new EnemyCatchAttack(enemy));
    }
}
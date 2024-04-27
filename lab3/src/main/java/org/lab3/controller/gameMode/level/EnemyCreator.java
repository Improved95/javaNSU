package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.enemyActions.EnemyAction;
import org.lab3.view.Constants;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.slashBlade.FrameSize;

import java.util.*;

public class EnemyCreator {
    private double createDelay;
    private double timerCreateDelay = createDelay;

    public void setCreateDelay(double createDelay) {
        this.createDelay = createDelay;
        timerCreateDelay = createDelay;
    }

    public void create(List<SamuraiV1> enemyList, AllCharactersActionsContext actionsContext,
                       FrameSize frameSize, double currentFPS) {

        if (timerCreateDelay <= 0) {
            SamuraiV1 enemy = new SamuraiV1(Constants.EnemyConstants.ENEMY_ATLAS);
            enemy.setScreenLayerLevel(1);
            enemy.getParametersContext().setSpeedOfMoveX(500);
            enemy.getParametersContext().setRadiusForwardAttack(80);
            enemy.getParametersContext().setRadiusBackwardAttack(10);
            enemy.getParametersContext().setAttackDuration(50);
            enemy.getParametersContext().setAttackDelay(200);
            enemy.setObjectSize(90);
            enemy.setScreenLayerLevel(1);
            enemy.setResourcesIndexInResourcesList(Constants.EnemyConstants.ENEMY_ATLAS_INDEX);
            enemy.setCurrentImageIndex(0);

            Random random = new Random();
            if (random.nextBoolean()) {
                enemy.setInGamePosition(-100, 0);
                enemy.changeDirection(1);
            } else {
                enemy.setInGamePosition(frameSize.getWidth() + 100, 0);
                enemy.changeDirection(-1);
            }

            fillEnemyMovement(actionsContext, enemy);
            enemyList.add(enemy);

            timerCreateDelay = createDelay;
        } else {
            timerCreateDelay -= 1000 / currentFPS;
        }
    }

    private void fillEnemyMovement(AllCharactersActionsContext actionsContext, SamuraiV1 enemy) {
        actionsContext.getEnemyActionsControllers().add(new EnemyAction(enemy));
    }
}
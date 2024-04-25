package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.enemyActions.EnemyAction;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.resources.ResourcesContext;
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
                       ResourcesContext enemyImagesResources, FrameSize frameSize, double currentFPS) {

        if (timerCreateDelay <= 0) {
            SamuraiV1 enemy = new SamuraiV1();
            enemy.setScreenLayerLevel(1);
            enemy.getParametersContext().setSpeedOfMoveX(500);
            enemy.getParametersContext().setRadiusForwardAttack(80);
            enemy.getParametersContext().setRadiusBackwardAttack(10);
            enemy.getParametersContext().setAttackDuration(50);
            enemy.getParametersContext().setAttackDelay(200);

            Random random = new Random();
            if (random.nextInt() % 2 == 1) {
                enemy.setInGamePosition(-100, 0);
                enemy.changeDirection(1);
            } else {
                enemy.setInGamePosition(frameSize.getWidth() + 100, 0);
                enemy.changeDirection(-1);
            }

            enemy.setImage(enemyImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

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
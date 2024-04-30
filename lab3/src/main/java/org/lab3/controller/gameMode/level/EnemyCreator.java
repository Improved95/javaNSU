package org.lab3.controller.gameMode.level;

import org.lab3.controller.actions.enemyActions.EnemyAction;
import org.lab3.model.objects.Constants;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.slashFX.SlashFX;
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
            SamuraiV1 enemy = new SamuraiV1();
            enemy.setScreenLayerLevel(1);
            enemy.setSpeedOfMoveX(500);
            enemy.setRadiusForwardAttack(80);
            enemy.setRadiusBackwardAttack(10);
            enemy.setAttackHeight(30);
            enemy.setAttackDuration(50);
            enemy.setAttackDelay(200);
            enemy.setObjectSize(90);
            enemy.setScreenLayerLevel(1);
            enemy.setResourcesIndexInResourcesList(Constants.EnemyConstants.ENEMY_ATLAS_INDEX);
            enemy.setCurrentImageIndex(0, 0);

            SlashFX slashFX = new SlashFX();
            slashFX.setObjectSize(70);
            slashFX.setCurrentImageIndex(0, 1);
            enemy.setSlashFX(slashFX);

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
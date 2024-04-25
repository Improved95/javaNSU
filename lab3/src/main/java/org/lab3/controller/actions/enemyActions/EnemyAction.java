package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.gameObjectsContext.ObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.characters.SamuraiV1;

public class EnemyAction implements ActionController {
    private SamuraiV1 character;

    private EnemyMoveX enemyMoveX;
    private EnemyAttack enemyAttack;
    private  EnemyCatchAttack enemyCatchAttack;

    public EnemyAction(SamuraiV1 character) {
        this.character = character;
        enemyMoveX = new EnemyMoveX();
        enemyAttack = new EnemyAttack(character);
        enemyCatchAttack = new EnemyCatchAttack();
    }

    public SamuraiV1 getCharacter() {
        return character;
    }

    public EnemyMoveX getEnemyMoveX() {
        return enemyMoveX;
    }

    public EnemyAttack getEnemyAttack() {
        return enemyAttack;
    }

    public EnemyCatchAttack getEnemyCatchAttack() {
        return enemyCatchAttack;
    }

    @Override
    public void nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                         double currentFPS, Model model) {

        enemyMoveX.execute(character, levelObjectsContext, currentFPS, model.getFrameSize());
        enemyAttack.execute(character, levelObjectsContext, currentFPS);
        enemyCatchAttack.execute(character, levelObjectsContext);

        if (character.getParametersContext().getHealth() <= 0) {
            levelObjectsContext.setScore(levelObjectsContext.getScore() + 1);
            character.setGameObjectIsExist(false);
        }
    }
}

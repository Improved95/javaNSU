package org.lab3.controller.actions.playerActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;

public class PlayerAttack extends ActionExecuteAbstract {
    private double attackDuration;
    private double attackDelay;

    public PlayerAttack(SamuraiV1 character) {
        initial(character);
    }

    public void initial(SamuraiV1 character) {
        this.attackDuration = character.getAttackDuration();
        this.attackDelay = character.getAttackDelay();
    }

    public void initialAttack() {
        isExecute = true;
    }

    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext, double currentFPS) {
        if (isExecute && !isBlockExecute) {
            if (attackDuration > 0) {
                character.setAttack(true);
                levelObjectsContext.getSlashFX().setGameObjectIsExist(true);
                attackDuration -= 1000 / currentFPS;
            } else {
                if (attackDelay > 0) {
                    attackDelay -= 1000 / currentFPS;
                    character.setAttack(false);
                    levelObjectsContext.getSlashFX().setGameObjectIsExist(false);
                } else {
                    isExecute = false;
                    attackDuration = character.getAttackDuration();
                    attackDelay = character.getAttackDelay();
                }
            }
        }
    }
}

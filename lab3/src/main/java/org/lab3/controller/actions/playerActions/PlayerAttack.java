package org.lab3.controller.actions.playerActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;

public class PlayerAttack extends ActionExecuteAbstract {
    private double attackDuration;
    private double attackDelay;

    public PlayerAttack(SlashBladeCharacterAbstract character) {
        initial(character);
    }

    public void initial(SlashBladeCharacterAbstract character) {
        this.attackDuration = character.getParametersContext().getAttackDuration();
        this.attackDelay = character.getParametersContext().getAttackDelay();
    }

    public void initialAttack() {
        isExecute = true;
    }

    public void execute(SamuraiV1 character, LevelObjectsContext levelObjectsContext, double currentFPS) {
        if (isExecute && !isBlockExecute) {
            if (attackDuration > 0) {
                character.getParametersContext().setAttackStatus(true);
                levelObjectsContext.getSlashFX().setGameObjectIsExist(true);
                attackDuration -= 1000 / currentFPS;
            } else {
                if (attackDelay > 0) {
                    attackDelay -= 1000 / currentFPS;
                    character.getParametersContext().setAttackStatus(false);
                    levelObjectsContext.getSlashFX().setGameObjectIsExist(false);
                } else {
                    isExecute = false;
                    attackDuration = character.getParametersContext().getAttackDuration();
                    attackDelay = character.getParametersContext().getAttackDelay();
                }
            }
        }
    }
}

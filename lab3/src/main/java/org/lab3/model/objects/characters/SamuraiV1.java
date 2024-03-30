package org.lab3.model.objects.characters;

import org.lab3.model.objects.characters.movement.SlashBladeCharacterAttack;
import org.lab3.model.objects.characters.movement.SlashBladeCharacterMoveX;

public class SamuraiV1 extends SlashBladeCharacterAbstract {
    public SamuraiV1() {
        parametersContext.setDirection(1);
        parametersContext.setSpeedOfMoveX(700);
        parametersContext.setAttackDuration(50);
        parametersContext.setAttackDelay(200);

        movementList.put("MOVE_X", new SlashBladeCharacterMoveX(this));
        movementList.put("ATTACK", new SlashBladeCharacterAttack(this, parametersContext.getAttackDuration(), parametersContext.getAttackDelay()));
    }
}

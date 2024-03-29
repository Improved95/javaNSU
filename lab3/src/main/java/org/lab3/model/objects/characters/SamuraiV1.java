package org.lab3.model.objects.characters;

import org.lab3.model.objects.characters.movement.SlashBladeCharacterMoveX;

public class SamuraiV1 extends Character {
    public SamuraiV1() {
        parametersContext.setDirection(1);
        parametersContext.setSpeedOfMoveX(700);

        movementList.put("MOVE_X", new SlashBladeCharacterMoveX(this));
        movementList.put("ATTACK", new SlashBladeCharacterMoveX(this));
    }
}

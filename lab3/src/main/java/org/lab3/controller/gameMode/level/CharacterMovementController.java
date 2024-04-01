package org.lab3.controller.gameMode.level;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;

class CharacterMovementController {
    public int aIsPress = 0;
    public int dIsPress = 0;

    /*public void changeMoveX(SlashBladeCharacterAbstract character, int a, int d) {
        if (a == 1) {
            if (dIsPress != 1) {
                character.changeDirection(-1);
                character.getMovementList().get("MOVE_X").changeExecuteStatus(true);
            } else {
                character.getMovementList().get("MOVE_X").changeExecuteStatus(false);
            }
            aIsPress = a;
        } else if (d == 1) {
            if (aIsPress != 1) {
                character.changeDirection(1);
                character.getMovementList().get("MOVE_X").changeExecuteStatus(true);
            } else {
                character.getMovementList().get("MOVE_X").changeExecuteStatus(false);
            }
            dIsPress = d;
        } else if (a == 0) {
            if (dIsPress == 1) {
                character.changeDirection(1);
                character.getMovementList().get("MOVE_X").changeExecuteStatus(true);
            }
            aIsPress = a;
        } else if (d == 0) {
            if (aIsPress == 1) {
                character.changeDirection(-1);
                character.getMovementList().get("MOVE_X").changeExecuteStatus(true);
            }
            dIsPress = d;
        }
        if ((aIsPress == 0 && dIsPress == 0) || (aIsPress == 1 && dIsPress == 1)) {
            character.getMovementList().get("MOVE_X").changeExecuteStatus(false);
        }
    }

    public void changeAttack(SlashBladeCharacterAbstract character) {
        character.getMovementList().get("ATTACK").changeExecuteStatus(true);
    }*/
}

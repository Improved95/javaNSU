package org.lab3.controller.actions.playerActions;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.objects.characters.SamuraiV1;

public class PlayerMoveX extends ActionExecuteAbstract {
    private int aIsPress = 0;
    private int dIsPress = 0;

    @Override
    public void initial() {
        this.isExecute = false;
        this.isBlockExecute = false;

        aIsPress = 0;
        dIsPress = 0;
    }

    public void changeMoveX(SamuraiV1 character, int a, int d) {
        if (a == 1) {
            if (dIsPress != 1) {
                character.changeDirection(-1);
                setExecuteStatus(true);
            } else {
                setExecuteStatus(false);
            }
            aIsPress = a;
        } else if (d == 1) {
            if (aIsPress != 1) {
                character.changeDirection(1);
                setExecuteStatus(true);
            } else {
                setExecuteStatus(false);
            }
            dIsPress = d;
        } else if (a == 0) {
            if (dIsPress == 1) {
                character.changeDirection(1);
                setExecuteStatus(true);
            }
            aIsPress = a;
        } else if (d == 0) {
            if (aIsPress == 1) {
                character.changeDirection(-1);
                setExecuteStatus(true);
            }
            dIsPress = d;
        }
        if ((aIsPress == 0 && dIsPress == 0) || (aIsPress == 1 && dIsPress == 1)) {
            setExecuteStatus(false);
        }
    }

    public void execute(SamuraiV1 character, double currentFPS) {
        if (isExecute && !isBlockExecute) {
            double speedOfMoveX = character.getSpeedOfMoveX();
            int direction = character.getInGameHorizontalDirection();
            character.setCurrentSpeedX(speedOfMoveX * direction / currentFPS);
        } else {
            character.setCurrentSpeedX(0);
        }
    }
}

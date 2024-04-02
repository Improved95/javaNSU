package org.lab3.controller.actions.samuraiActions;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public class SlashBladeCharacterCharacterMoveX extends SlashBladeCharacterActionControllerAbstract {
    private int aIsPress = 0;
    private int dIsPress = 0;

    public SlashBladeCharacterCharacterMoveX(SlashBladeCharacterAbstract character) {
        super(character);
    }

    @Override
    public void changeMoveX(int a, int d) {
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

    @Override
    public void execute(double currentFPS, FrameSize frameSize) {
        if (isExecute && !isBlockExecute) {
            double speedOfMoveX = character.getParametersContext().getSpeedOfMoveX();
            double reductionFactor = frameSize.getReductionFactor();
            int direction = character.getParametersContext().getInGameHorizontalDirection();
            character.changeInGamePos(speedOfMoveX * reductionFactor * direction / currentFPS, 0);
        }
    }
}

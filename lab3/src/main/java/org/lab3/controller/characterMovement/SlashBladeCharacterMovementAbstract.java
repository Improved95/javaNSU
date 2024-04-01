package org.lab3.controller.characterMovement;

import org.lab3.controller.characterMovement.CharacterMovement;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;

public abstract class SlashBladeCharacterMovementAbstract implements CharacterMovement {
    protected boolean isExecute = false;
    protected boolean blockExecute = false;

    @Override
    public void changeExecuteStatus(boolean isExecute) {
        this.isExecute = isExecute;
    }
}

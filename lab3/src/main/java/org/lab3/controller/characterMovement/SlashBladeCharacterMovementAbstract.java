package org.lab3.controller.characterMovement;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;

public abstract class SlashBladeCharacterMovementAbstract implements CharacterMovement {
    protected SlashBladeCharacterAbstract character;
    protected boolean isExecute = false;
    protected boolean blockExecute = false;
//    protected double timer;

    public SlashBladeCharacterMovementAbstract(SlashBladeCharacterAbstract character) {
        this.character = character;
    }

    @Override
    public void changeExecuteStatus(boolean isExecute) {
        this.isExecute = isExecute;
    }

    public boolean getExecuteStatus() {
        return isExecute;
    }
}

package org.lab3.model.objects.characters.movement;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;

public abstract class SlashBladeCharacterMovementAbstract implements CharacterMovement {
    protected SlashBladeCharacterAbstract character;
    protected boolean isExecute = false;
    protected double timer;

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

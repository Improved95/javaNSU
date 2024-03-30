package org.lab3.model.objects.characters.movement;

public abstract class SlashBladeCharacterMovementAbstract implements CharacterMovement {
    protected boolean isExecute = false;
    protected double timer;

    @Override
    public void changeExecuteStatus(boolean execute) {
        this.isExecute = execute;
    }
}

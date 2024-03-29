package org.lab3.model.objects.characters.movement;

public abstract class SlashBladeCharacterMovementAbstract implements CharacterMovement {
    private boolean execute = false;
    private double timer;

    @Override
    public void changeExecuteStatus(boolean execute) {
        this.execute = execute;
    }

    public boolean isExecute() {
        return execute;
    }
}

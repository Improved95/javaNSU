package org.lab3.model.objects.characters.movement;

import org.lab3.model.objects.characters.Character;

public abstract class SlashBladeCharacterMovementAbstract implements CharacterMovement {
    protected Character character;
    protected boolean execute = false;
    protected double timer;

    public SlashBladeCharacterMovementAbstract(Character character) {
        this.character = character;
    }

    @Override
    public void changeExecuteStatus(boolean execute) {
        this.execute = execute;
    }

    public boolean isExecute() {
        return execute;
    }
}

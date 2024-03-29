package org.lab3.model.objects.characters.movement;

import org.lab3.model.objects.characters.Character;

public class SlashBladeCharacterMoveX extends SlashBladeCharacterMovementAbstract {
    private CharacterParametersContext characterParametersContext;

    public SlashBladeCharacterMoveX(Character character) {
        super(character);
        character.getParametersContext();
    }

    @Override
    public void execute() {
    }
}

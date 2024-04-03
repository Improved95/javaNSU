package org.lab3.controller.actions.samuraiActions;

import org.lab3.controller.actions.ActionControllerAbstract;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;

public abstract class PlayerActionAbstract extends ActionControllerAbstract {
    protected SlashBladeCharacterAbstract character;

    public PlayerActionAbstract(SlashBladeCharacterAbstract character) {
        this.character = character;
    }

    public void attack() {}
    public void changeMoveX(int a, int d) {}
}

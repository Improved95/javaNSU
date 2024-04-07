package org.lab3.controller.actions.enemyActions;

import org.lab3.controller.actions.ActionControllerAbstract;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;


public abstract class EnemyActionAbstract extends ActionControllerAbstract {
    protected SlashBladeCharacterAbstract character;

    public EnemyActionAbstract(SlashBladeCharacterAbstract character) {
        this.character = character;
    }
}

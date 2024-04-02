package org.lab3.controller.actions.samuraiActions;

import org.lab3.controller.actions.ActionController;
import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;

public abstract class SlashBladeCharacterActionControllerAbstract implements ActionController {
    protected SlashBladeCharacterAbstract character;

    protected boolean isExecute = false;
    protected boolean isBlockExecute = false;

    public SlashBladeCharacterActionControllerAbstract(SlashBladeCharacterAbstract character) {
        this.character = character;
    }

    @Override
    public void setExecuteStatus(boolean isExecute) {
        this.isExecute = isExecute;
    }

    @Override
    public void setBlockExecuteStatus(boolean isBlockExecute) {
        this.isBlockExecute = isBlockExecute;
    }
}

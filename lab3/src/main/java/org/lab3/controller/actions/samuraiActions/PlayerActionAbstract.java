package org.lab3.controller.actions.samuraiActions;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public abstract class PlayerActionAbstract {
    protected boolean isExecute = false;
    protected boolean isBlockExecute = false;

    protected SlashBladeCharacterAbstract character;

    public PlayerActionAbstract(SlashBladeCharacterAbstract character) {
        this.character = character;
    }

    public void setExecuteStatus(boolean isExecute) {
        this.isExecute = isExecute;
    }

    public void setBlockExecuteStatus(boolean isBlockExecute) {
        this.isBlockExecute = isBlockExecute;
    }

    public abstract void execute(double currentFPS, FrameSize frameSize);

    public void attack() {}
    public void changeMoveX(int a, int d) {}
}

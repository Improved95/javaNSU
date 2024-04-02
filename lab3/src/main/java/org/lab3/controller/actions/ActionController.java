package org.lab3.controller.actions;

import org.lab3.model.objects.characters.SlashBladeCharacterAbstract;
import org.lab3.slashBlade.FrameSize;

public interface ActionController {
    void execute(double currentFPS, FrameSize frameSize);

    void setExecuteStatus(boolean execute);

    void setBlockExecuteStatus(boolean isBlockExecute);

    default void changeMoveX(int a, int d) {}

    default void attack() {};
}

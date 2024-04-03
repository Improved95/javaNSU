package org.lab3.controller.actions;

import org.lab3.slashBlade.FrameSize;

public interface ActionController {
    void execute(double currentFPS, FrameSize frameSize);

    void setExecuteStatus(boolean execute);

    void setBlockExecuteStatus(boolean isBlockExecute);
}

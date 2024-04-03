package org.lab3.controller.actions;

public abstract class ActionAbstract implements ActionController {
    protected boolean isExecute = false;
    protected boolean isBlockExecute = false;

    @Override
    public void setExecuteStatus(boolean isExecute) {
        this.isExecute = isExecute;
    }

    @Override
    public void setBlockExecuteStatus(boolean isBlockExecute) {
        this.isBlockExecute = isBlockExecute;
    }
}

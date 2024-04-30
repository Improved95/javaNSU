package org.lab3.controller.actions;

public abstract class ActionExecuteAbstract {
    protected boolean isExecute = false;
    protected boolean isBlockExecute = false;

    public void setExecuteStatus(boolean isExecute) {
        this.isExecute = isExecute;
    }

    public void setBlockExecuteStatus(boolean isBlockExecute) {
        this.isBlockExecute = isBlockExecute;
    }

    public boolean isExecute() {
        return isExecute;
    }

    public boolean isBlockExecute() {
        return isBlockExecute;
    }

    public void initial() {
        this.isExecute = true;
        this.isBlockExecute = false;
    }
}

package org.lab4.carFactory;

public class FactoryWorkflow {
    private JFrameObject jFrameObject;

    public FactoryWorkflow() {
        initial();
    }

    public void execute() {

    }

    private void initial() {
        jFrameObject = new JFrameObject();
    }
}

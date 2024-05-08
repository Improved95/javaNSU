package org.lab4;

import org.lab4.controller.factory.FactoryWorkflow;

public class Main {
    public static void main(String argv[]) {
        FactoryWorkflow factoryWorkflow = new FactoryWorkflow();
        factoryWorkflow.execute();
    }
}

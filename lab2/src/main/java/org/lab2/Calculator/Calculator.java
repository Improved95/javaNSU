package org.lab2.Calculator;

import org.lab2.Factory.CommandsFactory;
import org.lab2.commands.Commands;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Calculator {
    public void initialCalculator() {
        try {
            calculatorExecution();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch(InstantiationException ex) {
            ex.printStackTrace();
        } catch(IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private void calculatorExecution() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        CommandsFactory factory = new CommandsFactory();
            Commands command = factory.create("Add");
            command.execute();

    }
}

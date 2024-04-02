package org.lab3.controller.factories;

import org.lab3.controller.gameMode.GameMode;
import org.lab3.model.model.Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class GameModesFactory {
    private Properties gameModesProperty;

    public GameModesFactory() {
        this.gameModesProperty = setGameModesProperty();
    }

    public GameMode create(String modeName, Model model) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class classObject = Class.forName(gameModesProperty.getProperty(modeName));
        Constructor ctor = classObject.getDeclaredConstructor(Model.class);
        ctor.setAccessible(true);
        GameMode gameMode = (GameMode)ctor.newInstance(model);
        return gameMode;
    }

    private Properties setGameModesProperty() {
        Properties properties = new Properties();
        properties.setProperty("LEVEL", "org.lab3.controller.gameMode.level.Level");
        return properties;
    }
}

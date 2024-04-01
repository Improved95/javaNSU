package org.lab3.controller.gameMode.factories;

import org.lab3.controller.gameMode.GameMode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class GameModesFactory {
    private Properties gameModesProperty;

    public GameModesFactory() {
        this.gameModesProperty = setGameModesProperty();
    }

    public GameMode create(String modeName) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class classObject = Class.forName(gameModesProperty.getProperty(modeName));
        Constructor ctor = classObject.getDeclaredConstructor();
        ctor.setAccessible(true);
        GameMode gameMode = (GameMode)ctor.newInstance();
        return gameMode;
    }

    private Properties setGameModesProperty() {
        Properties properties = new Properties();
        properties.setProperty("LEVEL", "org.lab3.controller.gameMode.level.Level");
        return properties;
    }
}

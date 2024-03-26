package org.lab3.model.factories;

import org.lab3.model.Model;
import org.lab3.model.gameMode.GameMode;

import java.util.Properties;

public class GameModesFactory {
    private Properties gameModesProperty;

    public GameModesFactory() {
        this.gameModesProperty = setGameModesProperty();
    }

    public GameMode create(String modeName, Model model) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class classObject = Class.forName(gameModesProperty.getProperty(modeName));
        GameMode gameMode = (GameMode)classObject.newInstance();
        gameMode.setModelLoader(model);
        return gameMode;
    }

    private Properties setGameModesProperty() {
        Properties properties = new Properties();
        properties.setProperty("LEVEL", "org.lab3.model.gameMode.Level");
        return properties;
    }
}

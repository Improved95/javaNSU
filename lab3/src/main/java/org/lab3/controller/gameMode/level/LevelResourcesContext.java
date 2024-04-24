package org.lab3.controller.gameMode.level;

import org.lab3.resources.ResourcesContext;

public class LevelResourcesContext {
    private ResourcesContext playerImagesResources = new ResourcesContext();
    private ResourcesContext backgroundImagesResources = new ResourcesContext();
    private ResourcesContext enemyImagesResources = new ResourcesContext();
    private ResourcesContext slashFxImageResources = new ResourcesContext();

    public ResourcesContext getPlayerImagesResources() {
        return playerImagesResources;
    }

    public ResourcesContext getBackgroundImagesResources() {
        return backgroundImagesResources;
    }

    public ResourcesContext getEnemyImagesResources() {
        return enemyImagesResources;
    }

    public ResourcesContext getSlashFxImageResources() {
        return slashFxImageResources;
    }
}

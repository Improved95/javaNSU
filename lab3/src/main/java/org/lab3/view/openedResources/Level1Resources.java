package org.lab3.view.openedResources;

import org.lab3.resources.ResourcesContext;
import org.lab3.view.Constants;

import java.util.ArrayList;
import java.util.List;

public class Level1Resources implements OpenedResources {
    private List<ResourcesContext> resourcesList = new ArrayList<>();

    private ResourcesContext player = new ResourcesContext();
    private ResourcesContext enemy = new ResourcesContext();
    private ResourcesContext background = new ResourcesContext();
    private ResourcesContext slashFX = new ResourcesContext();

    public Level1Resources() {
        player.addImage(Constants.PlayerConstants.ZERO_ATLAS);
        enemy.addImage(Constants.EnemyConstants.ENEMY_ATLAS);
        background.addImage(Constants.BackgroundConstants.BACKGROUND_ATLAS);
        slashFX.addImage(Constants.FXConstants.SLASH_FX_ATLAS);

        resourcesList.add(player);
        resourcesList.add(enemy);
        resourcesList.add(background);
        resourcesList.add(slashFX);
    }

    @Override
    public List<ResourcesContext> getResourcesList() {
        return resourcesList;
    }
}

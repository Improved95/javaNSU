package org.lab3.view.openedResources;

import org.lab3.resources.*;
import org.lab3.view.Constants;

import java.util.ArrayList;
import java.util.List;

public class Level1Resources implements OpenedResources {
    private List<ObjectResources> resourcesList = new ArrayList<>();

    private ObjectResources player = new PlayerResources();
    private ObjectResources enemy = new PlayerResources();
    private ObjectResources background = new BackgroundResources();
    private ObjectResources slashFX = new SlashFxResources();

    public Level1Resources() {
        player.openResource(Constants.PlayerConstants.ZERO_ATLAS);
        enemy.openResource(Constants.EnemyConstants.ENEMY_ATLAS);
        background.openResource(Constants.BackgroundConstants.BACKGROUND_ATLAS);
        slashFX.openResource(Constants.FXConstants.SLASH_FX_ATLAS);

        resourcesList.add(player);
        resourcesList.add(enemy);
        resourcesList.add(background);
        resourcesList.add(slashFX);
    }

    @Override
    public List<ObjectResources> getResourcesList() {
        return resourcesList;
    }
}

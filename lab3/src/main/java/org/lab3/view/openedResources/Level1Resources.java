package org.lab3.view.openedResources;

import org.lab3.slashBlade.Constants;
import org.lab3.view.resources.*;

import java.util.ArrayList;
import java.util.List;

public class Level1Resources implements OpenedResources {
    private List<ObjectResources> resourcesList = new ArrayList<>();

    private ObjectResources player = new PlayerResources();
    private ObjectResources enemy = new PlayerResources();
    private ObjectResources background = new BackgroundResources();
    private ObjectResources slashFX = new SlashFxResources();
    private ObjectResources pause = new PauseResources();

    public Level1Resources() {
        player.openResource(Constants.PlayerConstants.ZERO_ATLAS);
        enemy.openResource(Constants.EnemyConstants.ENEMY_ATLAS);
        background.openResource(Constants.BackgroundConstants.BACKGROUND_ATLAS);
        slashFX.openResource(Constants.FXConstants.BLUE_SLASH_FX_ATLAS);
        slashFX.addImage(0, 1, Constants.FXConstants.RED_SLASH_FX_ATLAS);
        pause.openResource(Constants.PauseConstants.PAUSE_ATLAS);

        resourcesList.add(player);
        resourcesList.add(enemy);
        resourcesList.add(background);
        resourcesList.add(slashFX);
        resourcesList.add(pause);
    }

    @Override
    public List<ObjectResources> getResourcesList() {
        return resourcesList;
    }
}

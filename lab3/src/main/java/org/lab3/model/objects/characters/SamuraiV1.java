package org.lab3.model.objects.characters;

import org.lab3.view.Constants;

public class SamuraiV1 extends SlashBladeCharacterAbstract {
    public SamuraiV1() {
        parametersContext.setHealth(1);
        setScreenLayerLevel(1);
        setWidth(Constants.PlayerConstants.PLAYER_WIDTH);
        setHeight(Constants.PlayerConstants.PLAYER_HEIGHT);
        setObjectSize(100);
        setResourcesIndexInResourcesList(Constants.PlayerConstants.PLAYER_ATLAS_INDEX);
        setCurrentImageIndex(0);
    }
}

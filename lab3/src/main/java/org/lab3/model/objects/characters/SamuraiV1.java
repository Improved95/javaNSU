package org.lab3.model.objects.characters;

import org.lab3.model.Constants;

public class SamuraiV1 extends SlashBladeCharacterAbstract {
    public SamuraiV1(String atlas) {
        super(atlas);

        parametersContext.setHealth(1);
        setScreenLayerLevel(1);
        setWidth(Constants.PlayerConstants.PLAYER_WIDTH);
        setHeight(Constants.PlayerConstants.PLAYER_HEIGHT);
        setObjectSize(100);

        setImage();
    }

    @Override
    public void setImage() {
        this.image = resourcesContext.getOpenedResourcesList().get(0).getOpenedImage();
    }
}

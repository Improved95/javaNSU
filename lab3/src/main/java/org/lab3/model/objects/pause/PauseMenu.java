package org.lab3.model.objects.pause;

import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.view.Constants;

public class PauseMenu extends SlashBladeObjectAbstract implements PauseOverlay {
    public PauseMenu() {
        setWidth(Constants.FXConstants.SLASH_FX_WIDTH);
        setHeight(Constants.FXConstants.SLASH_FX_HEIGHT);
        setResourcesIndexInResourcesList(Constants.PauseConstants.PAUSE_FX_ATLAS_INDEX);
        setCurrentImageIndex(0, 0);
    }
}

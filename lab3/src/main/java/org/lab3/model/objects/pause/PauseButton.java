package org.lab3.model.objects.pause;

import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.model.Constants;

public class PauseButton extends SlashBladeObjectAbstract {
    public PauseButton(int i1, int i2) {
        setWidth(Constants.PauseConstants.PAUSE_BUTTON_WIDTH);
        setHeight(Constants.PauseConstants.PAUSE_BUTTON_HEIGHT);
        setResourcesIndexInResourcesList(Constants.PauseConstants.PAUSE_ATLAS_INDEX);
        setCurrentImageIndex(i1, i2);
        setObjectSize(100);
        setScreenLayerLevel(11);
    }
}

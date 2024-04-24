package org.lab3.controller.actions.SlashFX;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.slashFX.SlashFX;
import org.lab3.slashBlade.FrameSize;

public class SlashFXController implements ActionController {
    private SlashFX fx;

    private SlashFXFollowPlayer slashFXFollowPlayer;

    public SlashFXController(SlashFX slashFX) {
        this.fx = slashFX;
        this.slashFXFollowPlayer = new SlashFXFollowPlayer();
    }

    @Override
    public void nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                         double currentFPS, FrameSize frameSize) {

        slashFXFollowPlayer.execute(fx, levelObjectsContext);
    }
}

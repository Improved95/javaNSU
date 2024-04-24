package org.lab3.controller.actions.SlashFX;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.slashFX.SlashFX;
import org.lab3.slashBlade.FrameSize;

public class SlashFXController implements ActionController {
    private SlashFX fx;

    private SlashFXFollowPlayer slashFXFollowPlayer;

    public SlashFXController(SlashFX fx) {
        this.fx = fx;
        this.slashFXFollowPlayer = new SlashFXFollowPlayer();
        slashFXFollowPlayer.setExecuteStatus(true);
        slashFXFollowPlayer.setBlockExecuteStatus(false);
    }

    public SlashFX getFx() {
        return fx;
    }

    public SlashFXFollowPlayer getSlashFXFollowPlayer() {
        return slashFXFollowPlayer;
    }

    @Override
    public void nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                         double currentFPS, FrameSize frameSize) {

        slashFXFollowPlayer.execute(fx, levelObjectsContext);
    }
}

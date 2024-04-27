package org.lab3.controller.actions.SlashFX;

import org.lab3.controller.actions.ActionController;
import org.lab3.controller.gameMode.level.AllCharactersActionsContext;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.model.Model;
import org.lab3.model.objects.slashFX.SlashFX;

public class SlashFXAction implements ActionController {
    private SlashFX fx;

    private SlashFXFollowPlayer slashFXFollowPlayer;

    public SlashFXAction(SlashFX fx) {
        this.fx = fx;
        this.slashFXFollowPlayer = new SlashFXFollowPlayer();
    }

    public SlashFX getFx() {
        return fx;
    }

    public SlashFXFollowPlayer getSlashFXFollowPlayer() {
        return slashFXFollowPlayer;
    }

    public void initial() {
        slashFXFollowPlayer.setExecuteStatus(true);
        slashFXFollowPlayer.setBlockExecuteStatus(false);
    }

    @Override
    public void nextTick(LevelObjectsContext levelObjectsContext, AllCharactersActionsContext actionsContext,
                         double currentFPS, Model model) {

        slashFXFollowPlayer.execute(fx, levelObjectsContext);
    }
}

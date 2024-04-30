package org.lab3.controller.actions.SlashFX;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.slashFX.SlashFX;

public class SlashFXFollowPlayer extends ActionExecuteAbstract {
    public SlashFXFollowPlayer() {
        this.isExecute = true;
        this.isBlockExecute = false;
    }

    public void execute(SlashFX fx, SamuraiV1 player) {
        if (fx.isGameObjectIsExist()) {
            if (isExecute && !isBlockExecute) {
                int offsetX = 30;
                double posX = player.getInGamePosX() - (player.getWidth() / 2 - offsetX * player.getScreenHorizontalDirection());
                double posY = player.getInGamePosY() + player.getHeight() / 2 - fx.getHeight() / 2;

                fx.setInGamePosition(posX, posY);
                fx.setScreenHorizontalDirection(player.getScreenHorizontalDirection());
                fx.setScreenLayerLevel(player.getScreenLayerLevel() + 3);
            }
        }
    }
}

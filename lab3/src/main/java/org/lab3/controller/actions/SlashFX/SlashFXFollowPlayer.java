package org.lab3.controller.actions.SlashFX;

import org.lab3.controller.actions.ActionExecuteAbstract;
import org.lab3.model.gameObjectsContext.LevelObjectsContext;
import org.lab3.model.objects.SlashBladeObjectAbstract;
import org.lab3.model.objects.slashFX.SlashFX;

public class SlashFXFollowPlayer extends ActionExecuteAbstract {
    public void execute(SlashFX fx, LevelObjectsContext levelObjectsContext) {
        if (fx.isGameObjectIsExist()) {
            if (isExecute && !isBlockExecute) {
                SlashBladeObjectAbstract player = levelObjectsContext.getPlayer();
                fx.setInGamePosition(player.getInGamePosX() + 30 * player.getScreenHorizontalDirection(), player.getInGamePosY() + 35);
                fx.setScreenHorizontalDirection(player.getScreenHorizontalDirection());
                fx.setScreenLayerLevel(player.getScreenLayerLevel() + 1);
            }
        }
    }
}

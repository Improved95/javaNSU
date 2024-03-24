package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.gameMode.GameMode;
import org.lab3.slashBlade.JFrameObject;

import java.util.Set;

public class SlashBladeView implements View {
    @Override
    public void change(Model slashBladeModel, JFrameObject jFrameObject) throws IllegalAccessException {
        GameMode gameMode = slashBladeModel.getCurrentGameMode();
        Set<NeedDrawObject> drawObjectsList = gameMode.getDrawObjectsList();
//        jFrameObject.addObjectsOnFrame(drawObjectsList);
    }
}

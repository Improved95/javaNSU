package org.lab3.view;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.gameMode.GameMode;
import org.lab3.observers.ModelObservable;
import org.lab3.slashBlade.JFrameObject;

import java.util.Set;

public class SlashBladeView extends ViewObserverAbstract {
    public SlashBladeView(ModelObservable observableModel) {
        super(observableModel);
    }

    @Override
    public void update() {}

    @Override
    public void change(Model slashBladeModel, JFrameObject jFrameObject) throws IllegalAccessException {
        GameMode gameMode = slashBladeModel.getCurrentGameMode();
        Set<NeedDrawObject> drawObjectsList = gameMode.getDrawObjectsList();
//        jFrameObject.addObjectsOnFrame(drawObjectsList);
    }
}

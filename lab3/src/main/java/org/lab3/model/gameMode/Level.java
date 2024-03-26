package org.lab3.model.gameMode;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.resources.ResourcesContext;

import java.util.*;

public class Level implements GameMode {
    private Model modelLoader;

    private Background background;
    private SamuraiV1 samurai;

    private int a = 0;

    public Level(Model model) {
        this.modelLoader = model;
        this.background = new Background();
        this.samurai = new SamuraiV1();
    }

    @Override
    public void getDrawObjectsList(Set<NeedDrawObject> drawObjectsList) {
        drawObjectsList.add(samurai);
        drawObjectsList.add(background);
    }

    @Override
    public void execute() {
        background.setScreenLayerLevel(0);
        background.setInGamePosition(-400, -170);
        background.setScreenSize(115);

        samurai.setScreenLayerLevel(6);
        samurai.setInGamePosition(100 + 100 * a, 0);
        samurai.setScreenSize(40);
        a++;
    }

    @Override
    public void initial() {
        ResourcesContext samuraiImagesResources = new ResourcesContext();
        samuraiImagesResources.addImage("samurai/zero.png");
        this.samurai.getVisualContext().setImage(samuraiImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

        ResourcesContext backgroundImagesResources = new ResourcesContext();
        backgroundImagesResources.addImage("bg/bg1.jpg");
        this.background.getVisualContext().setImage(backgroundImagesResources.getOpenedResourcesList().get(0).getOpenedImage());

        modelLoader.notifyObserversModifyDrawObjectList();
    }
}

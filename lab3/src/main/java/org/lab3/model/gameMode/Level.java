package org.lab3.model.gameMode;

import org.lab3.model.NeedDrawObject;
import org.lab3.model.annotations.DrawObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.resources.ResourcesContext;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class Level implements GameMode {
    private Background background;
    private SamuraiV1 samurai;

    public Level() {
        this.background = new Background();
        this.samurai = new SamuraiV1();
        initial();
    }

    @Override
    public void getDrawObjectsList(Set<NeedDrawObject> drawObjectsList) throws IllegalAccessException {
        drawObjectsList.clear();
        /*Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().isAnnotationPresent(DrawObject.class)) {
                drawObjectsList.add((NeedDrawObject)field.get(this));
            }
        }*/
        drawObjectsList.add(samurai);
        drawObjectsList.add(background);
    }

    @Override
    public void execute() {
        background.setScreenLayerLevel(0);
        background.setInGamePosition(-400, -170);
        background.setScreenSize(115);

        samurai.setScreenLayerLevel(1);
        samurai.setInGamePosition(100, 0);
        samurai.setScreenSize(40);
    }

    private void initial() {
        ResourcesContext samuraiImagesResources = new ResourcesContext();
        ResourcesContext backgroundImagesResources = new ResourcesContext();
        try {

            samuraiImagesResources.addImage("samurai/zero.png");
            BufferedImage image = ImageIO.read(samuraiImagesResources.getOpenedResourcesList().get(0).getOpenedResource());
            this.samurai.getVisualContext().setImage(image);

            backgroundImagesResources.addImage("bg/bg1.jpg");
            image = ImageIO.read(backgroundImagesResources.getOpenedResourcesList().get(0).getOpenedResource());
            this.background.getVisualContext().setImage(image);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

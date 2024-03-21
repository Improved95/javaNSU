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
import java.util.AbstractList;
import java.util.ArrayList;

public class Level implements GameMode {
    private Background background;
    private SamuraiV1 samurai;

    public Level() {
        this.background = new Background(100, 100);
        this.samurai = new SamuraiV1(300, 20);
        initial();
    }

    @Override
    public AbstractList<NeedDrawObject> getNeedDrawObject() throws IllegalAccessException {
        AbstractList<NeedDrawObject> needDrawObjects = new ArrayList<>();

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().isAnnotationPresent(DrawObject.class)) {
                needDrawObjects.add((NeedDrawObject)field.get(this));
            }
        }

        return needDrawObjects;
    }

    @Override
    public void execute() {

    }

    private void initial() {
//        ResourcesContext samuraiImages = new ResourcesContext();
//        try {
//            samuraiImages.addImage("samurai/fifteen.jpg");
//            BufferedImage image = ImageIO.read(samuraiImages.getOpenedResourcesList().get(0).getOpenedResource());
//            this.samurai.getVisualContext().setImage(image);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        ResourcesContext samuraiImagesResources = new ResourcesContext();
        ResourcesContext backgroundImagesResources = new ResourcesContext();
        try {

            samuraiImagesResources.addImage("samurai/fifteen.jpg");
            BufferedImage image = ImageIO.read(samuraiImagesResources.getOpenedResourcesList().get(0).getOpenedResource());
            this.samurai.getVisualContext().setImage(image);

            backgroundImagesResources.addImage("bg/bg3.jpg");
            image = ImageIO.read(backgroundImagesResources.getOpenedResourcesList().get(0).getOpenedResource());
            this.background.getVisualContext().setImage(image);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

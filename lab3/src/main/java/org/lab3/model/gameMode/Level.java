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
    public Set<NeedDrawObject> getDrawObjectsList() throws IllegalAccessException {
        Set<NeedDrawObject> needDrawObjects = new TreeSet<>(new Comparator<NeedDrawObject>() {
            @Override
            public int compare(NeedDrawObject o1, NeedDrawObject o2) {
                return o1.getScreenLevelLayer() - o2.getScreenLevelLayer();
            }
        });

//        Field[] fields = this.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            if (field.getType().isAnnotationPresent(DrawObject.class)) {
//                needDrawObjects.add((NeedDrawObject)field.get(this));
//            }
//        }

        needDrawObjects.add(samurai);
        needDrawObjects.add(background);

        return needDrawObjects;
    }

    @Override
    public void execute() {
//        System.out.println("play");
    }

    private void initial() {
        ResourcesContext samuraiImagesResources = new ResourcesContext();
        ResourcesContext backgroundImagesResources = new ResourcesContext();
        try {

            samuraiImagesResources.addImage("samurai/fifteen.jpg");
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

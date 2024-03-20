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
import java.util.List;

public class Level implements GameMode {
    private Background background;
    private SamuraiV1 samurai;

    public Level() {
        this.background = new Background();
        background.setPosition(100, 0);

//        this.samurai = new SamuraiV1();
//        samurai.setPosition(300, 20);
        initial();
    }

    @Override
    public AbstractList<NeedDrawObject> getNeedDrawObject() {
        AbstractList<NeedDrawObject> needDrawObjects = new ArrayList<>();

        /*Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            if (field.getType().isAnnotationPresent(DrawObject.class)) {
                field.
//                needDrawObjects.add();
            }
        }*/

        needDrawObjects.add(background);
//        needDrawObjects.add(samurai);

        return needDrawObjects;
    }

    @Override
    public void execute() {

    }

    private void initial() {
        ResourcesContext samuraiImages = new ResourcesContext();
//        try {
//            samuraiImages.addImage("samurai/fifteen.jpg");
//            BufferedImage image = ImageIO.read(samuraiImages.getOpenedResourcesList().get(0).getOpenedResource());
//            this.samurai.getVisualContext().setImage(image);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        ResourcesContext backgroundImages = new ResourcesContext();
        try {
            backgroundImages.addImage("bg/bg1.jpg");
            BufferedImage image = ImageIO.read(samuraiImages.getOpenedResourcesList().get(0).getOpenedResource());
            this.background.getVisualContext().setImage(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

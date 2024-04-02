package org.lab3.model.gameObjectsContext;

import org.lab3.model.objects.DrawObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;

import java.util.*;

public class LevelObjectsContext implements ObjectsContext {
    private SamuraiV1 player = new SamuraiV1();
    private Background  background = new Background();
    private AbstractList<SamuraiV1> enemyList = new ArrayList();

    public SamuraiV1 getPlayer() {
        return player;
    }

    public void setPlayer(SamuraiV1 player) {
        this.player = player;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public List<SamuraiV1> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(AbstractList<SamuraiV1> enemyList) {
        this.enemyList = enemyList;
    }

    @Override
    public AbstractList<DrawObject> getDrawObjectsList() {
        AbstractList<DrawObject> objectsList = new ArrayList<>();

        objectsList.add(player);
        objectsList.add(background);
        for (SamuraiV1 enemy : enemyList) {
            objectsList.add(enemy);
        }

        return objectsList;
    }
}

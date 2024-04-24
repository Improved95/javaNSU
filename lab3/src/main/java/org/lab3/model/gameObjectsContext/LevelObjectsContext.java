package org.lab3.model.gameObjectsContext;

import org.lab3.model.objects.DrawObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.slashFX.SlashFX;

import java.util.*;

public class LevelObjectsContext implements ObjectsContext {
    private SamuraiV1 player;
    private Background  background;
    private List<SamuraiV1> enemyList = new ArrayList<>();
    private SlashFX slashFX;

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

    public void setEnemyList(List<SamuraiV1> enemyList) {
        this.enemyList = enemyList;
    }

    public SlashFX getSlashFX() {
        return slashFX;
    }

    public void setSlashFX(SlashFX slashFX) {
        this.slashFX = slashFX;
    }

    @Override
    public AbstractList<DrawObject> getDrawObjectsList() {
        AbstractList<DrawObject> objectsList = new ArrayList<>();

        objectsList.add(player);
//        objectsList.add(background);
        for (SamuraiV1 enemy : enemyList) {
            objectsList.add(enemy);
        }

        if (slashFX.isGameObjectIsExist()) {
            objectsList.add(slashFX);
        }

        return objectsList;
    }
}

package org.lab3.model.gameObjectsContext;

import org.lab3.model.objects.DrawObject;
import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;
import org.lab3.model.objects.pause.EndGamePause;
import org.lab3.model.objects.pause.Pause;
import org.lab3.model.objects.slashFX.SlashFX;

import java.util.*;

public class LevelObjectsContext implements ObjectsContext {
    private SamuraiV1 player;
    private Background  background;
    private List<SamuraiV1> enemyList = new ArrayList<>();
    private SlashFX slashFX;
    private Pause levelPause;
    private EndGamePause endGamePause;

    private int score = 0;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Pause getLevelPause() {
        return levelPause;
    }

    public void setLevelPause(Pause levelPause) {
        this.levelPause = levelPause;
    }

    public EndGamePause getEndGameMenu() {
        return endGamePause;
    }

    public void setEndGameMenu(EndGamePause endGameScreen) {
        this.endGamePause = endGameScreen;
    }

    @Override
    public AbstractList<DrawObject> getDrawObjectsList() {
        AbstractList<DrawObject> objectsList = new ArrayList<>();

        objectsList.add(player);

        objectsList.add(background);
        for (SamuraiV1 enemy : enemyList) {
            objectsList.add(enemy);
        }

        if (slashFX.isGameObjectIsExist()) {
            objectsList.add(slashFX);
        }

        if (levelPause.isGameObjectIsExist()) {
            objectsList.add(levelPause);
            objectsList.add(levelPause.getResume());
            objectsList.add(levelPause.getReset());
            objectsList.add(levelPause.getExit());
        }

        if (endGamePause.isGameObjectIsExist()) {
            objectsList.add(endGamePause);
            objectsList.add(endGamePause.getReset());
            objectsList.add(endGamePause.getExit());
        }

        return objectsList;
    }
}

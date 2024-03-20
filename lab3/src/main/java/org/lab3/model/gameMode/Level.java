package org.lab3.model.gameMode;

import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;

public class Level implements GameMode {

    private Background background;
    private SamuraiV1 samuraiV1;

    public Level() {
        initial();
    }

    @Override
    public void execute() {

    }

    private void initial() {
        background = new Background();

    }
}

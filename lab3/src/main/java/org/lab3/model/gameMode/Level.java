package org.lab3.model.gameMode;

import org.lab3.model.objects.backgrounds.Background;
import org.lab3.model.objects.characters.SamuraiV1;

public class Level implements GameMode {
    private Background background;
    private SamuraiV1 samuraiV1;

    public Level() {
        this.background = new Background();
    }

    @Override
    public void execute() {

    }


}

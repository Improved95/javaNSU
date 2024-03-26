package org.lab3.model.gameMode;

import org.lab3.model.Model;
import org.lab3.model.NeedDrawObject;

import java.util.Set;

public interface GameMode {
    void setModelLoader(Model model);
    void initial();

    void execute();
    void getDrawObjectsList(Set<NeedDrawObject> drawObjectsList);
}

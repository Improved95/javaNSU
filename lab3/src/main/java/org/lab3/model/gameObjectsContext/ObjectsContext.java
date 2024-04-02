package org.lab3.model.gameObjectsContext;

import org.lab3.model.objects.DrawObject;
import org.lab3.model.objects.SlashBladeObject;
import org.lab3.model.objects.SlashBladeObjectAbstract;

import java.util.AbstractList;

public interface ObjectsContext {
    AbstractList<DrawObject> getDrawObjectsList();
}

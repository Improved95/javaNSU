package org.lab3.model.gameObjectsContext;

import org.lab3.model.objects.SlashBladeObject;

import java.util.AbstractList;

public interface ObjectsContext {
    AbstractList<SlashBladeObject> createObjectsList();
}

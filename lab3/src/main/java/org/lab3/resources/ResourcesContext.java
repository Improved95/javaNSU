package org.lab3.resources;

import java.util.AbstractList;
import java.util.ArrayList;

public class ResourcesContext {
    private AbstractList<ResourcesView> openedResourcesList = new ArrayList<>();

    public void addImage(String path) {
        openedResourcesList.add(new SlashBladeResourcesView(path));
    }

    public AbstractList<ResourcesView> getOpenedResourcesList() {
        return openedResourcesList;
    }
}

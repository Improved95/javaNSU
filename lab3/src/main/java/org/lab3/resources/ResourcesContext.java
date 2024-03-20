package org.lab3.resources;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;

public class ResourcesContext implements AutoCloseable {
    private AbstractList<ResourcesView> openedResourcesList = new ArrayList<>();

    public void addImage(String path) throws IOException {
        openedResourcesList.add(new SlashBladeResourcesView(path));
    }

    public AbstractList<ResourcesView> getOpenedResourcesList() {
        return openedResourcesList;
    }

    @Override
    public void close() throws Exception {
        for (ResourcesView resource : openedResourcesList) {
            resource.close();
        }
    }
}

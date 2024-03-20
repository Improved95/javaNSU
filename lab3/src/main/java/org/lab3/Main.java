package org.lab3;

import org.lab3.resources.ResourcesContext;
import org.lab3.slashBlade.SlashBlade;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {

            SlashBlade slashBladeGameObj = new SlashBlade();
            slashBladeGameObj.initial();

    }

    /*public static ResourcesContext openResources() throws IOException {
        ResourcesContext resourcesContext = new ResourcesContext();
        resourcesContext.addBgImage("bg/bg1.jpg");

        return resourcesContext;
    }*/
}

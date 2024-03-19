package org.lab3;

import org.lab3.resources.characters.ResourcesContext;
import org.lab3.slashBlade.SlashBlade;

public class Main {
    public static void main(String args[]) {

        try (ResourcesContext resourcesContext = openResources()) {

            SlashBlade slashBladeGameObj = new SlashBlade();
            slashBladeGameObj.initial();

        } catch (Exception ex) {

        }

    }

    public static ResourcesContext openResources() {
        return new ResourcesContext();
    }
}

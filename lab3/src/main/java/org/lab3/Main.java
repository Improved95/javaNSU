package org.lab3;

import org.lab3.slashBlade.SlashBlade;
import org.lab3.view.bg.SlashBladeViewBG;
import org.lab3.view.bg.ViewBG;

public class Main {
    public static void main(String args[]) {
        try (ResourcesContext resourcesContext = openResources()) {

        }
        SlashBlade slashBladeGameObj = new SlashBlade();
        slashBladeGameObj.initial();
    }


    public static ResourcesContext openResources() {
        ViewBG bg = new SlashBladeViewBG();

    }
}

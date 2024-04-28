package org.lab3.controller.actions.helpMethods;

public class CollisionsDetect {
    public static boolean CollisionDetect(double x1, double y1, int w1, int h1, double x2, double y2, int w2, int h2) {
        if (!isSolid(x1 + w1, y1, x2, y2, w2, h2))
            if (!isSolid(x1 + w1, y1 + h1, x2, y2, w2, h2))
                if (!isSolid(x1, y1, x2, y2, w2, h2))
                    if (!isSolid(x1, y1 + h1, x2, y2, w2, h2))
                        return false;
        return true;
    }

    public static boolean isSolid(double x1, double y1, double x2, double y2, int w2, int h2) {
        if (x1 >= x2 && x1 <= x2 + w2 && y1 >= y2 && y1 <= y2 + h2) {
            return true;
        }
        return false;
    }
}

package org.lab3.controller.actions;

import org.lab3.controller.actions.samuraiActions.PlayerActionAbstract;

import java.util.HashMap;
import java.util.Map;

public class ObjectAndHisMovement<T, E> {
    T gameObject;
    Map<String, E> objectMovement = new HashMap<>();

    public T getGameObject() {
        return gameObject;
    }

    public void setGameObject(T gameObject) {
        this.gameObject = gameObject;
    }

    public Map<String, E> getObjectMovement() {
        return objectMovement;
    }

    public void setObjectMovement(Map<String, E> objectMovement) {
        this.objectMovement = objectMovement;
    }
}

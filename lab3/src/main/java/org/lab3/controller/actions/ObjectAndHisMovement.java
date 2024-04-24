package org.lab3.controller.actions;

public class ObjectAndHisMovement<T, E> {
    T gameObject;
    E objectMovement;

    public T getGameObject() {
        return gameObject;
    }

    public void setGameObject(T gameObject) {
        this.gameObject = gameObject;
    }

    public E getObjectMovement() {
        return objectMovement;
    }

    public void setObjectMovement(E objectMovement) {
        this.objectMovement = objectMovement;
    }
}

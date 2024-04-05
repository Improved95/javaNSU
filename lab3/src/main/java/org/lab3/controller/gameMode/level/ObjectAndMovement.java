package org.lab3.controller.gameMode.level;

public class ObjectAndMovement<T, E> {
    private T gameObject;
    private E ActionController;

    public T getGameObject() {
        return gameObject;
    }

    public void setGameObject(T gameObject) {
        this.gameObject = gameObject;
    }

    public E getActionController() {
        return ActionController;
    }

    public void setActionController(E actionController) {
        ActionController = actionController;
    }
}

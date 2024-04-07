package org.lab3.controller.gameMode.level;

import java.util.HashMap;
import java.util.Map;

public class ObjectAndHisMovement<T, E> {
     private T gameObject;
     private Map<String, E> ActionControllers = new HashMap<>();

     public ObjectAndHisMovement(T gameObject) {
         this.gameObject = gameObject;
     }

     public T getGameObject() {
         return gameObject;
     }

     public void setGameObject(T gameObject) {
         this.gameObject = gameObject;
     }

     public Map<String, E> getActionControllers() {
         return ActionControllers;
     }

     public void setActionControllers(Map<String, E> actionControllers) {
         ActionControllers = actionControllers;
     }
}

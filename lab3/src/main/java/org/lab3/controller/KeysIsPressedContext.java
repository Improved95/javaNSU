package org.lab3.controller;

import java.util.HashMap;
import java.util.Map;

public class KeysIsPressedContext {
    Map<Integer, KeyStatus> keysStatusMap = new HashMap<>();

    KeysIsPressedContext() {
        keysStatusMap.put(87, new KeyStatus()); // w
        keysStatusMap.put(65, new KeyStatus()); // a
        keysStatusMap.put(83, new KeyStatus()); // s
        keysStatusMap.put(68, new KeyStatus()); // d
        keysStatusMap.put(32, new KeyStatus()); // space
    }

    public int getKeyStatus(int keyCode) {
        if (keysStatusMap.containsKey(keyCode)) {
            return keysStatusMap.get(keyCode).status;
        }
        return -1;
    }

    public void setKeyStatus(int keyCode, int keyStatus) {
        if (keysStatusMap.containsKey(keyCode)) {
            keysStatusMap.get(keyCode).status = keyStatus;
        }
    }

    private class KeyStatus {
        public int status = 0;
    }
}

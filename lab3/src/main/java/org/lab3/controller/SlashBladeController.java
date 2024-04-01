package org.lab3.controller;

public class SlashBladeController {
    public void calculateNextFrame() {

    }

    private class TickGenerator {
        private final double maxFPS = 60;
        private final double maxWaitingTime = 1000 / maxFPS;

        private long nowTime;
        private long lastTime = System.currentTimeMillis();

        public double getMaxWaitingTime() {
            return maxWaitingTime;
        }

        public boolean isGenerateNext(long makeFrameTime) {
            nowTime = System.currentTimeMillis();
            if (nowTime - lastTime >= maxWaitingTime - makeFrameTime) {
                lastTime = nowTime;
                return true;
            }
            return false;
        }
    }

    private void initial() {

    }
}

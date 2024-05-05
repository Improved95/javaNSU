package org.lab3.slashBlade;

import java.security.PublicKey;

public class Constants {
    public static class GameConstants {
        public static final int EXIT_GAME = -1;
        public static final int NOTHING_DOING = 0;
        public static final int PUT_ON_PAUSE = 1;
        public static final int REMOVE_FROM_PAUSE = 2;
        public static final int RESET = 3;
        public static final int SWITCH_GAME_STATE = 4;

    }

    public static class PlayerConstants {
        public static final String ZERO_ATLAS = "samurai/zero.png";
        public static final String FIFTEEN_ATLAS = "samurai/fifteen.png";

        public static final int PLAYER_WIDTH = 109;
        public static final int PLAYER_HEIGHT = 130;

        public static final int PLAYER_ATLAS_INDEX = 0;
    }

    public static class EnemyConstants {
        public static final String ENEMY_ATLAS = "samurai/enemy.png";

        public static final int ENEMY_WIDTH = 109;
        public static final int ENEMY_HEIGHT = 130;

        public static final int ENEMY_ATLAS_INDEX = 1;
    }

    public static class BackgroundConstants {
        public static final String BACKGROUND_ATLAS = "bg/bg1.jpg";

        public static final int BACKGROUND_WIDTH = 2560;
        public static final int BACKGROUND_HEIGHT = 1080;

        public static final int BACKGROUND_ATLAS_INDEX = 2;
    }

    public static class FXConstants {
        public static final String BLUE_SLASH_FX_ATLAS = "fx/blue_slash.png";
        public static final String RED_SLASH_FX_ATLAS = "fx/red_slash.png";

        public static final int SLASH_FX_WIDTH = 290;
        public static final int SLASH_FX_HEIGHT = 70;

        public static final int SLASH_FX_ATLAS_INDEX = 3;
    }

    public static class PauseConstants {
        public static final String PAUSE_ATLAS = "pause/pause.png";

        public static final int PAUSE_WIDTH = 731;
        public static final int PAUSE_HEIGHT = 325;

        public static final int PAUSE_BG_WIDTH = 398;
        public static final int PAUSE_BG_HEIGHT = 398;

        public static final int PAUSE_BUTTON_WIDTH = 333;
        public static final int PAUSE_BUTTON_HEIGHT = 54;

        public static final int PAUSE_ATLAS_INDEX = 4;

        public static final int BUTTONS_INDEX = 1;
        public static final int RESUME_BUTTON_INDEX = 0;
        public static final int RESET_BUTTON_INDEX = 1;
        public static final int EXIT_BUTTON_INDEX = 2;
    }
}

package com.murilofb.darkestdungeonproject.models;

import com.murilofb.darkestdungeonproject.R;

public class MyConst {

    public static class DifficultyAndLevels {
        public static final int APPRENTICE_LEVEL = 0;
        public static final int VETERAN_LEVEL = 3;
        public static final int CHAMPION_LEVEL = 5;
        public static final int DIFFICULTY_NORMAL = 0;
        public static final int DIFFICULTY_STYGIAN = 1;
    }

    public static class CharStats {
        public static final String TYPE_HUMAN = "Human";
        public static final String SIZE_AVERAGE = "Average";
    }

    public static class Enemies {
        public static final Character BRAWLER(int level, int difficulty) {
            return new Character( level, difficulty)
                    .setType(CharStats.TYPE_HUMAN)
                    .setNames("Cultist Brawler", "Cultist Gladiator", "Cultist Champion")
                    .setImageResource(R.drawable.enemy_cultist_brawler)
                    .setSize(CharStats.SIZE_AVERAGE)
                    .setActionsPerRound(1)
                    .setHP(15,21,29,18,26,35);
        }
    }
}

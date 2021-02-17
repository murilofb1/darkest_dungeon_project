package com.murilofb.darkestdungeonproject.repository;

import com.murilofb.darkestdungeonproject.R;
import com.murilofb.darkestdungeonproject.models.Curio;
import com.murilofb.darkestdungeonproject.models.Enemy;
import com.murilofb.darkestdungeonproject.models.Provision;

public class MyConst {

    // Run Levels
    public static final int APPRENTICE_LEVEL = 0;
    public static final int VETERAN_LEVEL = 3;
    public static final int CHAMPION_LEVEL = 5;

    // Difficulty Levels
    public static final int DIFFICULTY_NORMAL = 0;
    public static final int DIFFICULTY_STYGIAN = 1;


    public class CurioStats {
        public static final String TYPE_TREASURE = "Treasure";
        public static final int INTERACTION_NOTHING = 0;
        public static final int INTERACTION_PURGE = 1;
        public static final int INTERACTION_HEIRLOOM = 2;
    }

    public static class CharStats {
        public static final String TYPE_HUMAN = "Human";
        public static final String SIZE_AVERAGE = "Average";
    }


    public static class ProvisionsDB {
        public static final Provision TORCH = new Provision("Torch", R.drawable.provision_torch);
    }

    public static class CuriosDB {

        public static final Curio CRATE() {
            Curio.Interaction default1 = new Curio.Interaction(CurioStats.INTERACTION_HEIRLOOM, "75% Heirloom");
            Curio.Interaction default2 = new Curio.Interaction(CurioStats.INTERACTION_HEIRLOOM, "25% Nothing");
            return new Curio()
                    .setName("Crate")
                    .setTypes(new String[]{CurioStats.TYPE_TREASURE})
                    .addInteraction(default1)
                    .addInteraction(default2);
        }
    }

    public static class EnemiesDB {

        public static final Enemy BRAWLER(int level, int difficulty) {
            return new Enemy(level, difficulty).setImageResource(R.drawable.enemy_cultist_brawler)
                    .setNames("Cultist Brawler", "Cultist Gladiator", "Cultist Champion")
                    .setType(CharStats.TYPE_HUMAN)
                    .setSize(CharStats.SIZE_AVERAGE)
                    .setActionsPerRound(1)
                    .setHp(15, 21, 29, 18, 26, 35)
                    .setDodge(0, 8.75, 21.25)
                    .setProtection(0, 0, 0)
                    .setSpeed(5, 6, 7)
                    .setStunRes(0.25, 0.45, 0.65)
                    .setBlightRes(0.20, 0.40, 0.60)
                    .setBleedRes(0.20, 0.40, 0.60)
                    .setDebuffRes(0.15, 0.35, 0.55)
                    .setMoveRes(0.25, 0.45, 0.65);
        }
    }
}

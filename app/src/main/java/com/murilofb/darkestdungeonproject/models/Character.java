package com.murilofb.darkestdungeonproject.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private String[] names = new String[3];
    private String type;
    private String size;
    private int actionsPerRound;
    private int[] hp;
    private double[] dodge;
    private List<Attack> attackList = new ArrayList<>();
    private int imageResource;
    private boolean isAlly;
    private int level;
    private int difficulty = MyConst.DifficultyAndLevels.DIFFICULTY_NORMAL; // Talvez não vá usar;

    //Contructor for enemies
    public Character(int level, int difficulty) {

        if (level == MyConst.DifficultyAndLevels.APPRENTICE_LEVEL) this.level = 0;
        else if (level == MyConst.DifficultyAndLevels.VETERAN_LEVEL) this.level = 1;
        else if (level == MyConst.DifficultyAndLevels.CHAMPION_LEVEL) this.level = 2;

        this.isAlly = false;
        this.difficulty = difficulty;
    }

    //Contructor for allies
    public Character(int level) {
        this.isAlly = true;
    }

    public Character setName(String name) {
        this.name = name;
        return this;
    }

    public Character setNames(String apprenticeName, @NonNull String veteranName, @NonNull String championName) {
        this.names[0] = apprenticeName;
        this.names[1] = veteranName;
        this.names[2] = championName;
        return this;
    }

    public String getName() {
        boolean singleName = names[0] == null && names[1] == null && names[2] == null;
        if (singleName) {
            return name;
        } else {
            return names[level];
        }
    }

    public Character setType(String type) {
        this.type = type;
        return this;
    }

    public Character setSize(String size) {
        this.size = size;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Character setActionsPerRound(int actionsPerRound) {
        this.actionsPerRound = actionsPerRound;
        return this;
    }

    public int getActionsPerRound() {
        return this.actionsPerRound;
    }

    public Character setHP(int hpApprent, int hpVet, int hpChamp, int hpApprent2, int hpVet2, int hpChamp2) {
        this.hp = new int[]{hpApprent, hpVet, hpChamp, hpApprent2, hpVet2, hpChamp2};
        return this;
    }

    public int getHp() {
        if (isAlly) return hp[level - 1];
        else {
            if (difficulty == MyConst.DifficultyAndLevels.DIFFICULTY_NORMAL) return hp[level];
            else return hp[level + 3];
        }
    }

    public Character setDodge(double dodgeApprent, double dodgeVet, double dodgeChamp) {
        this.dodge = new double[]{dodgeApprent, dodgeVet, dodgeChamp};
        return this;
    }

    public double getDodge() {
        if (isAlly) return dodge[level - 1];
        else return dodge[level];
    }

    public Character addAttack(Attack attack) {
        this.attackList.add(attack);
        return this;
    }

    public List<Attack> getAttackList() {
        return attackList;
    }

    public Character setImageResource(int drawableId) {
        this.imageResource = drawableId;
        return this;
    }

    public int getImageResource() {
        return imageResource;
    }

    public class Attack {
    }
}

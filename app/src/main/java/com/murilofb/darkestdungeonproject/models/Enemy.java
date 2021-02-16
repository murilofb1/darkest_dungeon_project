package com.murilofb.darkestdungeonproject.models;

import androidx.annotation.NonNull;

import com.murilofb.darkestdungeonproject.repository.MyConst;

public class Enemy extends Character {
    private String[] names = new String[3];

    private String type;
    private String size;
    private int actionsPerRound;
    private boolean[] stealth = {false, false, false};
    private int difficulty;
    //Resistances
    private double[] stunRes;
    private double[] blightRes;
    private double[] bleedRes;
    private double[] debuffRes;
    private double[] moveRes;

    public Enemy(int runLevel, int difficulty) {
        if (runLevel == MyConst.APPRENTICE_LEVEL) setArrIndex(0);
        else if (runLevel == MyConst.VETERAN_LEVEL) setArrIndex(1);
        else if (runLevel == MyConst.CHAMPION_LEVEL) setArrIndex(2);
        this.difficulty = difficulty;
    }

    public Enemy setNames(String apprenticeName, String veteranName, String championName) {
        this.names[0] = apprenticeName;
        this.names[1] = veteranName;
        this.names[2] = championName;
        return this;
    }

    public Enemy setHp(int hp1, int hp2, int hp3, int hp4, int hp5, int hp6) {
        int[] hpArr = new int[]{hp1, hp2, hp3, hp4, hp5, hp6};
        setHpArr(hpArr);
        return this;
    }

    @Override
    public int getHp() {
        int[] hpArr = getHpArr();
        if (difficulty == MyConst.DIFFICULTY_NORMAL)
            return hpArr[getArrIndex()];
        else return hpArr[getArrIndex() + 3];
    }

    public String getName() {
        return this.names[getArrIndex()];
    }

    public Enemy setType(String type) {
        this.type = type;
        return this;
    }

    public Enemy setSize(String size) {
        this.size = size;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Enemy setActionsPerRound(int actionsPerRound) {
        this.actionsPerRound = actionsPerRound;
        return this;
    }

    public int getActionsPerRound() {
        return this.actionsPerRound;
    }

    public boolean getStealth() {
        return stealth[getArrIndex()];
    }

    public Enemy setStealth(boolean stealth1, boolean stealth2, boolean stealth3) {
        stealth[0] = stealth1;
        stealth[1] = stealth2;
        stealth[2] = stealth3;
        return this;
    }

    public double getStunRes() {
        return stunRes[getArrIndex()];
    }

    public Enemy setStunRes(double stunRes1, double stunRes2, double stunRes3) {
        this.stunRes = new double[]{stunRes1, stunRes2, stunRes3};
        return this;
    }

    public double getBlightRes() {
        return blightRes[getArrIndex()];
    }

    public Enemy setBlightRes(double blightRes1, double blightRes2, double blightRes3) {
        this.blightRes = new double[]{blightRes1, blightRes2, blightRes3};
        return this;
    }

    public double getBleedRes() {
        return bleedRes[getArrIndex()];
    }

    public Enemy setBleedRes(double bleedRes1, double bleedRes2, double bleedRes3) {
        this.bleedRes = new double[]{bleedRes1, bleedRes2, bleedRes3};
        return this;
    }

    public double getDebuffRes() {
        return debuffRes[getArrIndex()];
    }

    public Enemy setDebuffRes(double debuffRes1, double debuffRes2, double debuffRes3) {
        this.bleedRes = new double[]{debuffRes1, debuffRes2, debuffRes3};
        return this;
    }

    public double getMoveRes() {
        return moveRes[getArrIndex()];
    }

    public Enemy setMoveRes(double moveRes1, double moveRes2, double moveRes3) {
        this.moveRes = new double[]{moveRes1, moveRes2, moveRes3};
        return this;
    }

    //Custom setters for common attributes
    public Enemy setDodge(double dodgeApprent, double dodgeVet, double dodgeChamp) {
        setDodgeArr(new double[]{dodgeApprent, dodgeVet, dodgeChamp});
        return this;
    }

    public Enemy setProtection(double prot1, double prot2, double prot3) {
        setProtectionArr(new double[]{prot1, prot2, prot3});
        return this;
    }

    public Enemy setSpeed(int spd1, int spd2, int spd3) {
        setSpeedArr(new int[]{spd1, spd2, spd3});
        return this;
    }

    public Enemy setImageResource(int drawableId) {
        this.imageResource = drawableId;
        return this;
    }

}

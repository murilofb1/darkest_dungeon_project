package com.murilofb.darkestdungeonproject.models;


import java.util.ArrayList;
import java.util.List;

public class Character {
    //Info
    protected int imageResource;

    //Base Stats
    private int[] hp;
    private double[] dodge;
    private double[] protection;
    private int[] speed;

    //Attacks
    private List<Attack> attackList = new ArrayList<>();

    //About Difficulty
    private int arrIndex;

    public Character() {
    }

    public Character setImageResource(int drawableId) {
        this.imageResource = drawableId;
        return this;
    }

    public int getImageResource() {
        return imageResource;
    }

    protected void setHpArr(int[] hp) {
        this.hp = hp;
    }

    protected int[] getHpArr() {
        return hp;
    }

    public int getHp() {
        return hp[arrIndex];
    }

    protected void setDodgeArr(double[] dodge) {
        this.dodge = dodge;
    }

    public double getDodge() {
        return dodge[arrIndex];
    }

    protected void setProtectionArr(double[] protection) {
        this.protection = protection;
    }

    public double getProtection() {
        return protection[arrIndex];
    }

    public int getSpeed() {
        return speed[arrIndex];
    }

    protected void setSpeedArr(int[] speed) {
        this.speed = speed;
    }

    public Character addAttack(Attack attack) {
        this.attackList.add(attack);
        return this;
    }

    public List<Attack> getAttackList() {
        return attackList;
    }


    protected void setArrIndex(int arrIndex) {
        this.arrIndex = arrIndex;
    }

    public int getArrIndex() {
        return arrIndex;
    }

    public class Attack {
    }
}

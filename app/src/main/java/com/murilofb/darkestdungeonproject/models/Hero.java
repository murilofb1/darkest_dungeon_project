package com.murilofb.darkestdungeonproject.models;

public class Hero extends Character {
    private String name;
    //Resistances
    private double stunRes;
    private double blightRes;
    private double bleedRes;
    private double debuffRes;
    private double moveRes;
    private double diseaseRes;
    private double deathblowRes;
    private double trapRes;


    public Hero(int level) {
        if (level == 6) setArrIndex(4);
        else setArrIndex(level - 1);
    }
    public Hero setHp(int hp1, int hp2, int hp3, int hp4, int hp5) {
        int[] hpArr = new int[]{hp1, hp2, hp3, hp4, hp5};
        setHpArr(hpArr);
        return this;
    }
    public Character setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Hero setResistances(double stunRes, double blightRes, double bleedRes, double debuffRes, double moveRes, double diseaseRes, double deathblowRes, double trapRes) {
        this.stunRes = stunRes;
        this.blightRes = blightRes;
        this.bleedRes = bleedRes;
        this.debuffRes = debuffRes;
        this.moveRes = moveRes;
        this.deathblowRes = deathblowRes;
        this.diseaseRes = diseaseRes;
        this.trapRes = trapRes;
        return this;
    }

    public double getStunRes() {
        return stunRes;
    }

    /*
        public Hero setStunRes(double stunRes) {
            this.stunRes = stunRes;
            return this;
        }
    */
    public double getBlightRes() {
        return blightRes;
    }

    /*
        public Hero setBlightRes(double blightRes) {
            this.blightRes = blightRes;
            return this;
        }
    */
    public double getBleedRes() {
        return bleedRes;
    }

    /*
        public Hero setBleedRes(double bleedRes) {
            this.bleedRes = bleedRes;
            return this;
        }
    */
    public double getDebuffRes() {
        return debuffRes;
    }

    /*
        public Hero setDebuffRes(double debuffRes) {
            this.debuffRes = debuffRes;
            return this;
        }
    */
    public double getMoveRes() {
        return moveRes;
    }

    /*
        public Hero setMoveRes(double moveRes) {
            this.moveRes = moveRes;
            return this;
        }
    */
    public double getDiseaseRes() {
        return diseaseRes;
    }

    /*
        public Hero setDiseaseRes(double diseaseRes) {
            this.diseaseRes = diseaseRes;
            return this;
        }
    */
    public double getDeathblowRes() {
        return deathblowRes;
    }

    /*
        public Hero setDeathblowRes(double deathblowRes) {
            this.deathblowRes = deathblowRes;
            return this;
        }
    */
    public double getTrapRes() {
        return trapRes;
    }

    /*
        public Hero setTrapRes(double trapRes) {
            this.trapRes = trapRes;
            return this;
        }
    */
    //Custom setters for common attributes
    public Hero setDodge(double dodge1, double dodge2, double dodge3, double dodge4, double dodge5) {
        setDodgeArr(new double[]{dodge1, dodge2, dodge3, dodge4, dodge5});
        return this;
    }

    public Hero setProtection(double prot1, double prot2, double prot3, double prot4, double prot5) {
        setProtectionArr(new double[]{prot1, prot2, prot3, prot4, prot5});
        return this;
    }

    public Hero setSpeed(int spd1, int spd2, int spd3, int spd4, int spd5) {
        setSpeedArr(new int[]{spd1, spd2, spd3, spd4, spd5});
        return this;
    }

    public Hero setImageResource(int drawableId) {
        this.imageResource = drawableId;
        return this;
    }


}

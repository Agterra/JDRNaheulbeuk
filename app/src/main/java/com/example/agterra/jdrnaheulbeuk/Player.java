package com.example.agterra.jdrnaheulbeuk;

import java.io.Serializable;

/**
 * Created by Agterra on 11/07/2017.
 */

public class Player implements Serializable{

    public static enum Race
    {

        humain,
        barbare,
        nain,
        hautElfe,
        demiElfe,
        elfeSylvain,
        elfeNoir,
        orque,
        demiOrque,
        gobelin,
        ogre,
        semiHomme,
        gnome

    }

    public static enum Metier
    {

        guerrier,
        ninja,
        voleur,
        pretre,
        mage,
        paladin,
        ranger,
        menestrel,
        pirate,
        marchand,
        ingenieur,
        noble

    }

    private int courage;

    private int intelligence;

    private int charisma;

    private int adress;

    private int force;

    private int magicResistance;

    private int pierceResistance;

    private int gold;

    private int silver;

    private int lifePoints;

    private int pointsDestin;

    private int otherEnergy;

    private int level;

    private String race;

    private String metier;

    private int attack;

    private int parade;

    public Player(int courage, int intelligence, int charisma, int adress, int force) {

        this.courage = courage;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.adress = adress;
        this.force = force;

        this.gold = 0;

        this.silver = 0;

        this.pointsDestin = 0;

        this.pierceResistance = 0;

        this.magicResistance = (int)Math.ceil((courage + intelligence + force)/3);

        this.level = 1;

        this.otherEnergy = 0;

        this.lifePoints = 30;

        this.attack = 8;

        this.parade = 10;

    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setParade(int parade) {
        this.parade = parade;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public void setOtherEnergy(int energyAstrale) {
        this.otherEnergy = energyAstrale;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setAdress(int adress) {
        this.adress = adress;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setMagicResistance(int magicResistance) {
        this.magicResistance = magicResistance;
    }

    public void setPierceResistance(int pierceResistance) {
        this.pierceResistance = pierceResistance;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setPointsDestin(int pointsDestin) {
        this.pointsDestin = pointsDestin;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public int getSilver() {
        return silver;
    }

    public int getOtherEnergy() {
        return otherEnergy;
    }

    public int getCourage() {
        return courage;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getAdress() {
        return adress;
    }

    public int getForce() {
        return force;
    }

    public int getMagicResistance() {
        return magicResistance;
    }

    public int getPierceResistance() {
        return pierceResistance;
    }

    public int getGold() {
        return gold;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getPointsDestin() {
        return pointsDestin;
    }

    public int getLevel() {
        return level;
    }

    public String getRace() {
        return race;
    }

    public String getMetier() {
        return metier;
    }

    public int getAttack() {
        return attack;
    }

    public int getParade() {
        return parade;
    }
}

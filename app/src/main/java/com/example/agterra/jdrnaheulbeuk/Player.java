package com.example.agterra.jdrnaheulbeuk;

/**
 * Created by Agterra on 11/07/2017.
 */

public class Player {

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

    private int lifePoints;

    private int pointsDestin;

    private int level;

    private String Race;

    private String Metier;

    public Player(int courage, int intelligence, int charisma, int adress, int force, int gold, int pointsDestin) {

        this.courage = courage;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.adress = adress;
        this.force = force;
        this.gold = gold;
        this.pointsDestin = pointsDestin;

        this.magicResistance = (int)Math.ceil((courage + intelligence + force)/3);

    }
}

package com.ironhack.battlesimulator;

import java.util.Scanner;

public class Wizard extends Character implements Attacker {

    private int mana;
    private int intelligence;

    public Wizard(int hp, String name, Boolean isAlive, Party party, int mana, int intelligence) {
        super(hp, name, isAlive, party);
        setMana(mana);
        setIntelligence(intelligence);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public static void createManually() {
        int hp;
        String name;
        Party party;
        Integer mana;
        Integer intelligence;

        String userInput = null;
        Scanner in = new Scanner(System.in);

        System.out.println("Lets create a new Wizard!");
        System.out.println("By which name goes the new Wizard?");
        name = in.next();
        do {
            System.out.println("How healthy is " + name + "? Everything between 100-200 is allowed.");
            hp = Integer.parseInt(in.next());
            if (hp < 100 || hp > 200) {
                System.err.println("Try again. " + hp + " is out of the allowed boundary.");
            }
        } while (hp < 100 || hp > 200);

        do {
            System.out.println("How much mana possess " + name + "? Please enter a value of min. 10 and max. 50.");
            mana = Integer.parseInt(in.next());
            if (mana < 10 || mana > 50) {
                System.err.println("Sorry, a mana of " + mana + " is out limits.");
            }
        } while (mana < 10 || mana > 50);
        do {
            System.out.println(name + " is a mighty Wizard. But how much mana does " + name + " have? More 1 or near to 50?");
            intelligence= Integer.parseInt(in.next());
            if (intelligence < 1 || intelligence > 50) {
                System.err.println("A strength of " + intelligence + " is not allowed. Try again.");
            }
        } while (intelligence < 1 || intelligence > 50);

        System.out.println("And finally to which party belongs our new Wizard?");
        //Hier sollte besser eine Liste der bestehenden Parties zur Auswahl angezeigt werden
        //Derzeit führen PartyNames mit Leerzeichen zu einer NullPointerExeption
        party = Party.getListOfParties().get(0); //Totaler Blödsinn, da so immer der erste Eintrag gelesen wird

        Wizard wizard = new Wizard(hp, name, true, party, mana, intelligence);
    }

    // Attack Method
    @Override
    public double attack() {
        int givenDamage = 0;
        if (getMana() - 5 > 0) {
            givenDamage = doPowerAttack();
        } else {
            givenDamage = doNormalAttack();
        }
        return givenDamage;
    }

    @Override
    public int doPowerAttack() {
        System.out.println("Fireball!!!!!");
        setMana(getMana()-5);
        return getIntelligence();
    }

    @Override
    public int doNormalAttack() {
        System.out.println("Staff hit!");
        setMana(getMana() + 1);
        return 2;
    }
    @Override
    public void receiveDamage ( int damage){
        System.out.println("new HP = getHP - damage: " + this.getHp() + " - " + damage);
        this.setHp(this.getHp()-damage > 0 ? this.getHp()-damage : 0);
        if (this.getHp() <= 0) this.isAlive(false);
    }

}

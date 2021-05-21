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
        Party party = null;
        Integer mana;
        Integer intelligence;

        String userInput = null;
        Scanner in = new Scanner(System.in);

        System.out.println("Lets create a new Wizard!");
        System.out.println("By which name goes the new Wizard?");
        userInput = in.nextLine();
        name = userInput;
        do {
            System.out.println("How healthy is " + name + "? Everything between 100-200 is allowed.");
            userInput = in.nextLine();
            hp = Integer.parseInt(userInput);
            if (hp < 100 || hp > 200) {
                System.err.println("Try again. " + hp + " is out of the allowed boundary.");
            }
        } while (hp < 100 || hp > 200);

        do {
            System.out.println("How much mana possess " + name + "? Please enter a value of min. 10 and max. 50.");
            userInput = in.nextLine();
            mana = Integer.parseInt(userInput);
            if (mana < 10 || mana > 50) {
                System.err.println("Sorry, a mana of " + mana + " is out limits.");
            }
        } while (mana < 10 || mana > 50);
        do {
            System.out.println(name + " is a mighty Wizard. But how much mana does " + name + " have? More 1 or near to 50?");
            userInput = in.nextLine();
            intelligence= Integer.parseInt(userInput);
            if (intelligence < 1 || intelligence > 50) {
                System.err.println("A strength of " + intelligence + " is not allowed. Try again.");
            }
        } while (intelligence < 1 || intelligence > 50);

        do {
            System.out.println("And finally to which party belongs our new Warrior?");
            Party.showExistingParties();
            userInput = in.nextLine();
            if (Party.existsParty(userInput)) {
                party = Party.getMapOfParties().get(userInput);
            } else {
                System.err.println("Sorry the party " + userInput + " doesn't exist. Try again.");
            }
        } while (!Party.existsParty(userInput));

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
        System.out.println(this.getName() + " is throwing a Fireball!!!!!");
        setMana(getMana()-5);
        return getIntelligence();
    }

    @Override
    public int doNormalAttack() {
        System.out.println(this.getName() + " is doing a Staff hit!");
        setMana(getMana() + 1);
        return 2;
    }
    @Override
    public void receiveDamage ( int damage){
        //System.out.println("new HP = getHP - damage: " + this.getHp() + " - " + damage); for debugging
        this.setHp(this.getHp()-damage > 0 ? this.getHp()-damage : 0);
        if (this.getHp() <= 0) this.isAlive(false);
    }

}

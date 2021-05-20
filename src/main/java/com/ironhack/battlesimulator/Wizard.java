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
        party = Party.getMapOfPartys().get(in.next());

        Wizard wizard = new Wizard(hp, name, true, party, mana, intelligence);
    }

    // Attack Method
    @Override
    public void attack(Character opponent) {
        if (opponent.getAlive().equals(true)) {
            if (mana >= 5) {
                System.out.println("Wizard " + this.getName() + " throws a Fireball, with a damage of " + intelligence + " Health Points");
                mana = mana - 5;
                int newHp = opponent.getHp() - intelligence;
                if (newHp > 0) {
                    opponent.setHp(newHp);
                } else {
                    opponent.setHp(0);
                    System.out.println("Wizard " + this.getName() + " killed " + opponent.getName());
                    opponent.setAlive(false);
                }
            } else {
                System.out.println("Wizard " + this.getName() + " lands a Staff hit, with a damage of " + 2 + " Health Points");
                mana = mana + 1;
                int newHp = opponent.getHp() - 2;
                if (newHp > 0) {
                    opponent.setHp(newHp);
                } else {
                    opponent.setHp(0);
                    System.out.println("Wizard " + this.getName() + " killed " + opponent.getName());
                    opponent.setAlive(false);
                }
            }
        } else {
            System.out.println("Wizard " + this.getName() + " don´t fight dead people");
        }
    }
}

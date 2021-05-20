package com.ironhack.battlesimulator;

import java.util.Scanner;

public class Warrior extends Character implements Attacker {

    private Integer stamina;
    private Integer strength;

    public Warrior(int hp, String name, Boolean isAlive, Party party, Integer stamina, Integer strength) {
        super(hp, name, isAlive, party);
        this.stamina = stamina;
        this.strength = strength;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getStamina() {
        return stamina;
    }

    public Integer getStrength() {
        return strength;
    }

    public static void createManually() {
        int hp;
        String name;
        Party party;
        Integer stamina;
        Integer strength;

        String userInput = null;
        Scanner in = new Scanner(System.in);

        System.out.println("Lets create a new Warrior!");
        System.out.println("What is the name of our new Warrior?");
        name = in.next();
        System.out.println("How healthy is " + name + "? Everything between 100-200 is allowed.");
        hp = Integer.parseInt(in.next());
        System.out.println("How much stamina possess " + name + "? Please enter a value of min. 10 and max. 50.");
        stamina = Integer.parseInt(in.next());
        System.out.println(name + "is a might Warrior. But how strong? More 1 or near to 10?");
        strength= Integer.parseInt(in.next());
        System.out.println("And finaly to which party belongs our new Warrior?");
        party = Party.getMapOfPartys().get(in.next());
        Warrior warrior = new Warrior(hp, name, true, party, stamina, strength);
    }

    // Attack Method
    @Override
    public double attack() {
        int givenDamage = 0;
        if (getStamina() - 5 > 0) {
            givenDamage = doPowerAttack();
        } else {
            givenDamage = doNormalAttack();
        }
        return givenDamage;
    }

    @Override
    public int doPowerAttack() {
        System.out.println("Heavy attack!!!");
        setStamina(getStamina()-5);
        return getStrength();
    }

    @Override
    public int doNormalAttack() {
        System.out.println("Weak attack!");
        setStamina(getStamina()+1);
        return (int) getStrength()/2;
    }

    @Override
    public void receiveDamage(int damage) {
        System.out.println("new HP = getHP - damage: " + this.getHp() + " - " + damage);
        this.setHp(this.getHp()-damage > 0 ? this.getHp()-damage : 0);
        if(this.getHp() <= 0) this.setAlive(false);
    }

}


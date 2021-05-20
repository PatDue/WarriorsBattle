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
        Party party = null;
        Integer stamina;
        Integer strength;

        String userInput = null;
        Scanner in = new Scanner(System.in);

        System.out.println("Lets create a new Warrior!");
        System.out.println("What is the name of our new Warrior?");
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
        System.out.println("How much stamina possess " + name + "? Please enter a value of min. 10 and max. 50.");
        userInput = in.nextLine();
        stamina = Integer.parseInt(userInput);
            if (stamina < 10 || stamina > 50) {
                System.err.println("Sorry, a stamina of " + stamina + " is out limits.");
            }
        } while (stamina < 10 || stamina > 50);
        do {
            System.out.println(name + " is a mighty Warrior. But how strong? More 1 or near to 10?");
            userInput = in.nextLine();
            strength= Integer.parseInt(userInput);
            if (strength < 1 || strength > 10) {
                System.err.println("A strength of " + strength + " is not allowed. Try again.");
            }
        } while (strength < 1 || strength > 10);

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
        if(this.getHp() <= 0) this.isAlive(false);
    }

}


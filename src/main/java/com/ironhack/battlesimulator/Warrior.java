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
    public void attack(Character opponent) {
        if (opponent.getAlive().equals(true)) {
            if (stamina >= 5) {
                System.out.println("Warrior " + this.getName() + " lands a Heavy Attack, with a damage of " + strength + " Health Points");
                stamina = stamina - 5;
                int newHp = opponent.getHp() - strength;
                if (newHp > 0) {
                    opponent.setHp(newHp);
                } else {
                    opponent.setHp(0);
                    System.out.println("Warrior " + this.getName() + " killed " +opponent.getName());
                    opponent.setAlive(false);
                }
            } else {
                System.out.println("Warrior " + this.getName() + " lands Weak Attack, with a damage of " + strength / 2 + " Health Points");
                stamina = stamina + 1;
                int newHp = opponent.getHp() - strength / 2;
                if (newHp > 0) {
                    opponent.setHp(newHp);
                } else {
                    opponent.setHp(0);
                    System.out.println("Warrior " + this.getName() + " killed " + opponent.getName());
                    opponent.setAlive(false);
                }
            }
        } else {
            System.out.println("Warrior " + this.getName() + " think that it isn't necessary to fight a dead one");
        }
    }
}

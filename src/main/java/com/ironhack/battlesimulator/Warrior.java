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
        do {
            System.out.println("How healthy is " + name + "? Everything between 100-200 is allowed.");
            hp = Integer.parseInt(in.next());
            if (hp < 100 || hp > 200) {
                System.err.println("Try again. " + hp + " is out of the allowed boundary.");
            }
        } while (hp < 100 || hp > 200);

        do {
        System.out.println("How much stamina possess " + name + "? Please enter a value of min. 10 and max. 50.");
        stamina = Integer.parseInt(in.next());
            if (stamina < 10 || stamina > 50) {
                System.err.println("Sorry, a stamina of " + stamina + " is out limits.");
            }
        } while (stamina < 10 || stamina > 50);
        do {
            System.out.println(name + " is a mighty Warrior. But how strong? More 1 or near to 10?");
            strength= Integer.parseInt(in.next());
            if (strength < 1 || strength > 10) {
                System.err.println("A strength of " + strength + " is not allowed. Try again.");
            }
        } while (strength < 1 || strength > 10);

        System.out.println("And finally to which party belongs our new Warrior?");
        //Hier sollte besser eine Liste der bestehenden Parties zur Auswahl angezeigt werden
        //Derzeit führen PartyNames mit Leerzeichen zu einer NullPointerExeption
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

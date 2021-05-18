package com.ironhack.battlesimulator;

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
                int newHp = opponent.getHp() - strength / 2;
                opponent.setHp(newHp);
                stamina = stamina + 1;
            }
        } else {
            System.out.println("Warrior " + this.getName() + " think that it isn't necessary to fight a dead one");
        }
    }
}

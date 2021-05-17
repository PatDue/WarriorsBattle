package com.ironhack.battlesimulator;

public class Warrior extends Character implements Attacker {

    private Integer stamina;
    private Integer strength;

    public Warrior(Integer id, Integer hp, String name, Boolean isAlive, Integer stamina, Integer strength) {
        super(id, hp, name, isAlive);
        this.stamina = stamina;
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
    public void attack(Character character) {
        if (character.getAlive().equals(true)) {
            if (stamina >= 5) {
                System.out.println("Warrior " + this.getName() + " lands a Heavy Attack, with a damage of " + strength + " Health Points");
                stamina = stamina - 5;
                int newHp = character.getHp() - strength;
                if (newHp > 0) {
                    character.setHp(newHp);
                } else {
                    character.setHp(0);
                    System.out.println("Warrior " + this.getName() + " killed " +character.getName());
                    character.setAlive(false);
                }
            } else {
                System.out.println("Warrior " + this.getName() + " lands Weak Attack, with a damage of " + strength / 2 + " Health Points");
                int newHp = character.getHp() - strength / 2;
                character.setHp(newHp);
                stamina = stamina + 1;
            }
        } else {
            System.out.println("Warrior " + this.getName() + " think that it isn#t necessary to fight a dead one");
        }
    }
}

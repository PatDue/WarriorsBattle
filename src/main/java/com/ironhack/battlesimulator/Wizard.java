package com.ironhack.battlesimulator;

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

    // Attack Method
    @Override
    public void attack(Character character) {
        if (character.getAlive().equals(true)) {
            if (mana >= 5) {
                System.out.println("Wizard " + this.getName() + " throws a Fireball, with a damage of " + intelligence + " Health Points");
                mana = mana - 5;
                int newHp = character.getHp() - intelligence;
                if (newHp > 0) {
                    character.setHp(newHp);
                } else {
                    character.setHp(0);
                    System.out.println("Wizard " + this.getName() + " killed " + character.getName());
                    character.setAlive(false);
                }
            } else {
                System.out.println("Wizard " + this.getName() + " lands a Staff hit, with a damage of " + 2 + " Health Points");
                int newHp = character.getHp() - 2;
                character.setHp(newHp);
                mana = mana + 1;
            }
        } else {
            System.out.println("Wizard " + this.getName() + " don´t fight dead people");
        }
    }
}

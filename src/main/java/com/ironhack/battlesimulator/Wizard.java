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
        if (this.getHp() <= 0) this.setAlive(false);
    }

}

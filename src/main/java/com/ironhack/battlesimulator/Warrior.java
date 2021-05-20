package com.ironhack.battlesimulator;

public class Warrior extends Character  {

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


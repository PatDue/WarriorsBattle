package com.ironhack.battlesimulator;

public interface Attacker {

    double attack();
    int doPowerAttack();
    int doNormalAttack();
    void receiveDamage(int damage);

}

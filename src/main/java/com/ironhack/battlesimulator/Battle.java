package com.ironhack.battlesimulator;

import java.util.List;
import java.util.Random;

public class Battle {
    private Character duellist1;
    private Integer startEnduranceDuellist1;
    private Character duellist2;
    private Integer startEnduranceDuellist2;
    private int rounds = 0;
    private String statusOfBattle = "inProgress";
    private List<Character> duellist;

    public Battle(Character duellist1, Character duellist2) {
        this.duellist1 = duellist1;
        this.startEnduranceDuellist1 = getEndurance(duellist1);
        this.duellist2 = duellist2;
        this.startEnduranceDuellist2 = getEndurance(duellist2);
    }


    public Integer getEndurance(Character duellist) {
        Integer endurance = 0;
        switch (duellist.getCHARACTER_TYPE()) {
            case "Wizard":
                Wizard wiz = (Wizard) duellist;
                endurance = wiz.getMana();
                break;
            case "Warrior":
                Warrior war = (Warrior) duellist;
                endurance = war.getStamina();
            break;
        }
        return endurance;
    }

    public void showStatsForCharacter(String chracterType, Character character) {
        switch (chracterType) {
            case "Wizard":
                Wizard wizard = (Wizard) character;
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println("Name: " + wizard.getName() + " (" + chracterType + "");
                System.out.println("Party: " + wizard.getParty().getPartyName());
                System.out.println("Mana: " + wizard.getMana());
                System.out.println("Intelligence: " + wizard.getIntelligence());
                System.out.println("HP: " + wizard.getHp());
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                break;
            case "Warrior":
                Warrior warrior = (Warrior) character;
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println("Name: " + warrior.getName() + " (" + chracterType + ")");
                System.out.println("Party: " + warrior.getParty().getPartyName());
                System.out.println("Stamina: " + warrior.getStamina());
                System.out.println("Strength: " + warrior.getStrength());
                System.out.println("HP: " + warrior.getHp());
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                break;
        }
    }

    public void fight(){
        this.rounds++;
        int givenDamageDuellist1 = 0;
        int givenDamageDuellist2 = 0;
        System.out.println("#############################################################");
        System.out.println("Round:" + this.rounds);
        showStatsForCharacter(duellist1.getCHARACTER_TYPE(), duellist1);
        showStatsForCharacter(duellist2.getCHARACTER_TYPE(), duellist2);

        double d1 = this.duellist1.attack() * getPowerOfAttack(startEnduranceDuellist1, getEndurance(duellist1));
        double d2 =  this.duellist2.attack() * getPowerOfAttack(startEnduranceDuellist2, getEndurance(duellist2));
        System.out.println("damage1 (double) " + Double.toString(d1));
        System.out.println("damage2 (double) " + Double.toString(d2));
        givenDamageDuellist1 = (int) d1;
        givenDamageDuellist2 = (int) d2;
        System.out.println(this.duellist1.getName() +"("+this.duellist1.getParty().getPartyName() +") hit with damage: " + givenDamageDuellist1);
        System.out.println(this.duellist2.getName() +"("+this.duellist2.getParty().getPartyName() +") hit with damage: " + givenDamageDuellist2);

        System.out.println("------------------------Round result------------------------");
        this.duellist1.receiveDamage(givenDamageDuellist2);
        this.duellist2.receiveDamage(givenDamageDuellist1);
        System.out.println(this.duellist1.getName() +"("+this.duellist1.getParty().getPartyName()+") has left: ");
        System.out.println("\tHP =>" + this.duellist1.getHp());
        System.out.println("\tis still Alive => " + this.duellist1.isAlive());
        System.out.println(this.duellist2.getName() +"("+this.duellist2.getParty().getPartyName()+") has left: ");
        System.out.println("\tHP =>" + this.duellist2.getHp());
        System.out.println("\tis still Alive => " + this.duellist2.isAlive());
    }

    private double getPowerOfAttack(Integer startPower, Integer leftPower) {
        double percentage = ((double) leftPower*100)/startPower;
        double random = new Random().nextDouble();
        double rn = (100 + (random * (percentage - 100)) ) * 0.01;
        System.out.println("POWER ----------------> " + Double.toString(rn));
        return rn;
    }

}
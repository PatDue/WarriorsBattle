package com.ironhack.battlesimulator;

public class Main {

    public static void main(String[] args) {

        Party redArmy = new Party("Red Army");
        Party blueArmy = new Party("Blue Army");
        redArmy.createRandomMembers();
        blueArmy.createRandomMembers();

        while (redArmy.getRandomMember() != null && blueArmy.getRandomMember() != null) {
            Battle schlacht = new Battle(redArmy.getRandomMember(), blueArmy.getRandomMember());
            schlacht.fight();
        }

        Party winner;
        if (redArmy.getRandomMember() != null) {
            winner = redArmy;
        } else {
            winner = blueArmy;
        }

        System.out.println("THE WINNER is " + winner.getPartyName());
    }
}

package com.ironhack.battlesimulator;

public class Game {

    public void startGame() {

        Party redArmy = new Party("Red Army");
        Party blueArmy = new Party("Blue Army");
        redArmy.createRandomMembers();
        blueArmy.createRandomMembers();

        while (redArmy.getRandomMember() != null && blueArmy.getRandomMember() != null) {
            Character character1 = redArmy.getRandomMember();
            Character character2 = blueArmy.getRandomMember();

            Battle schlacht = new Battle(character1, character2);
            while (character1.isAlive() && character2.isAlive()) {
                schlacht.fight();
            }
        }
        if (redArmy.getRandomMember() != null && blueArmy.getRandomMember() == null) {
            System.out.println("the victory is yours");
        } else {
            System.out.println("Your Army loose, try again!");
        }
    }
}

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
            System.out.println((char) 27 + "\u001b[43m"+"Congratulations! The victory is yours!" + "\033[0m" + "\n");
        } else {
            System.out.println((char) 27 + "\u001b[47m"+"Your Army lost... but don't worry, you can try again!" + "\033[0m" + "\n");
        }
    }
}

package com.ironhack.battlesimulator;

public class Game {
    Integer counter;

    public Game(Integer counter) {
        this.counter = counter;
    }

    public Integer getCounter() {
        return counter;
    }

    public void startGame() {

        Party redArmy = new Party("Red Army");
        Party blueArmy = new Party("Blue Army");
        redArmy.createRandomMembers();
        blueArmy.createRandomMembers();

        while (redArmy.getRandomMember() != null && blueArmy.getRandomMember() != null) {
            Character character1 = redArmy.getRandomMember();
            Character character2 = blueArmy.getRandomMember();

            Battle schlacht = new Battle(character1, character2);
            while(character1.isAlive() && character2.isAlive()){
                schlacht.fight();
            }

//            battleLooserIs(redArmy);
//            battleLooserIs(blueArmy);
        }

//        Party winner;
//        if (redArmy.getRandomMember() != null) {
//            winner = redArmy;
//        } else {
//            winner = blueArmy;
//        }
//
//        System.out.println("THE WINNER is " + winner.getPartyName());
    }
//    public void battleLooserIs(Party party){
//        if(party.getRandomMember() == null){
//            System.out.println(party.getPartyName() + " loose the fight");
//        }
//    }
}

package com.ironhack.battlesimulator;

import java.util.ArrayList;

public class Graveyard {

    private static ArrayList<Character> deadPartyMembers = new ArrayList<>();


    //get dead members
    public static ArrayList<Character> getDeadPartyMembers() {
        return deadPartyMembers;
    }

    // Method to be called after a fight to bury a character on the graveyard
    public static void bury(Character character) {
        deadPartyMembers.add(character);
        System.out.println(character + " lost all the HealthPoints and got buried on the graveyard.");
    }

    //Method to show all members in the graveyard
    public static void showGraveyardMembers() {
        for (Character deadCharacter : deadPartyMembers) {
            System.out.println(deadCharacter);
        }
    }


    @Override
    public String toString() {
        return "Graveyard{" +
                "deadPartyMembers=" + deadPartyMembers +
                '}';
    }


}

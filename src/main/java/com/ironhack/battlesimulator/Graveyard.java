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
        System.out.println("\n"+character.getName() + " lost all the HealthPoints and got buried on the graveyard."+"\n");
    }

    //Method to show all members in the graveyard
    public static void showGraveyardMembers() {
        System.out.println(" ");
        System.out.println("----- THE GRAVEYARD -----");
        System.out.println(" ");
        for (Character deadCharacter : deadPartyMembers) {
            System.out.println(deadCharacter.getName());
        }
        System.out.println(" ");
    }


    @Override
    public String toString() {
        return "Graveyard{" +
                "deadPartyMembers=" + deadPartyMembers +
                '}';
    }


}

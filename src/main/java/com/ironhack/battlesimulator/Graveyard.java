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
        System.out.println((char) 27 + "[31m" + "\u001b[1m"+ "\n"+character.getName() + " lost all the HealthPoints and got buried on the graveyard." + "\033[0m" + "\n");
    }

    //Method to show all members in the graveyard
    public static void showGraveyardMembers() {
        System.out.println("\n" + (char) 27 + "[7m"+ "----- THE GRAVEYARD -----" + "\033[0m" + "\n");
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

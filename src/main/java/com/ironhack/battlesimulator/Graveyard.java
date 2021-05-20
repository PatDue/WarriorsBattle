package com.ironhack.battlesimulator;

import java.util.ArrayList;

public class Graveyard {

    private static ArrayList<Character> deadPartyMembers = new ArrayList<>();


    //get dead members
    public static ArrayList<Character> getDeadPartyMembers() {
        return deadPartyMembers;
    }

// Method to be called after a fight to bury a character on the graveyard
    public static void bury(Character character){
        deadPartyMembers.add(character);
        System.out.println(character +" lost all the HealthPoints and got buried on the graveyard.");
    }


// Search for dead Party members?
//       for (Character C : deadPartyMembers){
//        System.out.println(deadPartyMembers[C]);
//

    @Override
    public String toString() {
        return "Graveyard{" +
                "deadPartyMembers=" + deadPartyMembers +
                '}';
    }

    
}

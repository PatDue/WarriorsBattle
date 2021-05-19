package com.ironhack.battlesimulator;

public class Main {

    public static void main(String[] args) {
        Party blackParty = new Party("Black Party");
        Warrior.createManually();
        blackParty.showMembers(true);

    }
}

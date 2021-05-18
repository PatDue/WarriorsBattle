package com.ironhack.battlesimulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {

    @Test
    void creatParty() {
        Party testPartyNo1 = new Party("Red Army");
        assertTrue(testPartyNo1.getPartyName() != "undefined");
    }

    @Test
    void addMember() {
        Party testPartyNo1 = new Party("Red Army");
        Warrior testWarriorNo1 = new Warrior(1,100, "Roland", true, "Red Army", 100, 100);
        testPartyNo1.addMember(testWarriorNo1);
        assertEquals(testWarriorNo1, testPartyNo1.getMembers().get(0));
    }

//    @Test
//    void createRandomMembers() {
//    }

    @Test
    void showMembers() {
        String expectedOutput = "The Red Army consists of following members:\nName: Roland, Health Points: 100\nName: Conan, Health Points: 100\nName: Sieffried, Health Points: 100\nName: Roy, Health Points: 100\n";


        ByteArrayOutputStream outgoingMessages = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outgoingMessages));
        Party testPartyNo1 = new Party("Red Army");
        Warrior testWarriorNo1 = new Warrior(1,100, "Roland", true, "Red Army", 100, 100);
        Warrior testWarriorNo2 = new Warrior(2,100, "Conan", true, "Red Army", 95, 105);
        Wizard testWizardNo1 = new Wizard(3,100, "Siegfried", true, "Red Army", 90, 105);
        Wizard testWizardNo2 = new Wizard(4,100, "Roy", true, "Red Army", 85, 105);
        testPartyNo1.showMembers(true);
        assertEquals(expectedOutput, outgoingMessages.toString());
        System.setOut(originalOut);
        // Fehleranalyse basiert auf https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    }

    @Test
    void getPartyName() {
        Party testPartyNo1 = new Party("Red Army");
        assertEquals("Red Army" ,testPartyNo1.getPartyName());
    }
}
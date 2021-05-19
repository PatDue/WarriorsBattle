package com.ironhack.battlesimulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {

    Party testPartyNo1;

    @BeforeEach
    void BeforeEach() {
        testPartyNo1 = new Party("Red Army");
    }

    @Test
    void creatParty() {
        assertTrue(testPartyNo1.getPartyName() != "undefined");
    }

    @Test
    void addMember() {
        Warrior testWarriorNo1 = new Warrior(100, "Roland", true, testPartyNo1, 100, 100);
        assertEquals(testWarriorNo1, testPartyNo1.getMembers().get(0));
    }

    @Test
    void createRandomMembers() {
        testPartyNo1.createRandomMembers();
        assertNotNull(testPartyNo1.getMembers());
    }

    @Test
    void exportParty() throws Exception{
        testPartyNo1.createRandomMembers();
        assertNotNull(testPartyNo1.getMembers());
        testPartyNo1.exportParty();
//        Files file = new Files();
//        assertTrue(Files.exists(testPartyNo1.getPartyName()+".csv"));
    }

    @Test
    void showMembers() {
        String expectedOutput = "The Red Army consists of following members:\nName: Roland, Health Points: 100\nName: Conan, Health Points: 100\nName: Siegfried, Health Points: 100\nName: Roy, Health Points: 100\n";
        Warrior testWarriorNo1 = new Warrior(100, "Roland", true, testPartyNo1, 100, 100);
        Warrior testWarriorNo2 = new Warrior(100, "Conan", true, testPartyNo1, 95, 105);
        Wizard testWizardNo1 = new Wizard(100, "Siegfried", true, testPartyNo1, 90, 105);
        Wizard testWizardNo2 = new Wizard(100, "Roy", true, testPartyNo1, 85, 105);
        ByteArrayOutputStream outgoingMessages = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outgoingMessages));
        testPartyNo1.showMembers(true);
        assertEquals(expectedOutput, outgoingMessages.toString());
        System.setOut(originalOut);
        // Fehleranalyse basiert auf https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    }

    @Test
    void getPartyName() {
        assertEquals("Red Army" ,testPartyNo1.getPartyName());
    }
}
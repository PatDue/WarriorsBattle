package com.ironhack.battlesimulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    Party testParty;
    Warrior testWarriorNo1;

    @BeforeEach
    void beforeEach() {
        testParty = new Party("Black");
        testWarriorNo1 = new Warrior(150, "Roland", true, testParty, 10, 10);
    }

    @Test
    void getStamina() {
        assertEquals(10, testWarriorNo1.getStamina());
    }

    @Test
    void getStrength() {
        assertEquals(10, testWarriorNo1.getStrength());
    }

    @Test
    void setStamina() {
        testWarriorNo1.setStamina(20);
        assertEquals(20, testWarriorNo1.getStamina());
    }

    @Test
    void setStrength() {
        testWarriorNo1.setStrength(15);
        assertEquals(15, testWarriorNo1.getStrength());
    }

//    @Test
//    void createManually() {
//        Warrior.createManually();
//        assertTrue(false);
//    }
}
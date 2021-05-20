package com.ironhack.battlesimulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    void fight() {
        Party testPartyNo1 = new Party("Red Army");
        Party testPartyNo2 = new Party("Black Army");

        Warrior testWarriorNo1 = new Warrior(200, "Roland", true, testPartyNo1, 50, 8);
        Warrior testWarriorNo2 = new Warrior(150, "Conan", true, testPartyNo2, 25, 10);
        Wizard testWizardNo1 = new Wizard(100, "Siegfried", true, testPartyNo1, 50, 45);
        Wizard testWizardNo2 = new Wizard(70, "Roy", true, testPartyNo2, 35, 40);

        Battle andAction = new Battle(testWarriorNo1, testWizardNo2);
        while(testWarriorNo1.isAlive() && testWizardNo2.isAlive()) {
            assertDoesNotThrow(()-> andAction.fight());
        }
    }
}
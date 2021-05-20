package com.ironhack.battlesimulator;

public enum physicalCharacteristics {
    HP_WIZARD_MIN(50),
    HP_WIZARD_MAX(100),
    HP_WARRIOR_MIN(100),
    HP_WARRIOR_MAX(200),
    STAMINA_MIN(10),
    STAMINA_MAX(50),
    STRENGTH_MIN(1),
    STRENGTH_MAX(10),
    MANA_MIN(10),
    MANA_MAX(50),
    INTELLIGENCE_MIN(1),
    INTELLIGENCE_MAX(50);

    private physicalCharacteristics(int value) {
        this.value = value;
    }
    public final int value;

    public int getValue() {
        return value;
    }
}

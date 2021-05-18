package com.ironhack.battlesimulator;

import java.util.UUID;

public abstract class Character {
    String id = UUID.randomUUID().toString(); // unique identifier

    private int hp;
    private String name;
    private Boolean isAlive;
    private Party party;
    private final String CHARACTER_TYPE;

    public Character(int hp, String name, boolean isAlive, Party party) {
        this.hp = hp;
        this.name = name;
        this.isAlive = isAlive;
        this.party = party;
        this.CHARACTER_TYPE = getClass().getName();
        party.addMember(this);
    }


    public String getId() { return id; }


    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) { this.hp = hp; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Party getParty() { return party; }

    public void setParty(Party party) { this.party = party; }

    public String getCHARACTER_TYPE() {
        return CHARACTER_TYPE;
    }
}



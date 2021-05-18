package com.ironhack.battlesimulator;

public abstract class Character {
    private Integer id;
    private int hp;
    private String name;
    private Boolean isAlive;
    private Party party;

    public Character(int id, int hp, String name, boolean isAlive, Party party) {
        this.id = id;
        this.hp = hp;
        this.name = name;
        this.isAlive = isAlive;
        this.party = party;
    }


    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

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
}



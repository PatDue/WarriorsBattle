package com.ironhack.battlesimulator;

public abstract class Character {
private Integer id;
private Integer hp;
private String name;
private Boolean isAlive;

    public Character(Integer id, Integer hp, String name, Boolean isAlive) {
        setId(id);
        setHp(hp);
        setName(name);
        setAlive(isAlive);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

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
}



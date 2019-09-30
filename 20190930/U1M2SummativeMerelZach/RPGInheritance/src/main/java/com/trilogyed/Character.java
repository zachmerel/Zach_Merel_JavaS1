package com.trilogyed;

public class Character {
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    public Character(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void Run(int speed) {
        System.out.println(speed);
    }

    public void Attack(int attackPower) {
        System.out.println(attackPower);
    }

    public void Heal(int health) {
        System.out.println(health);
    }

    public void DecreaseHealth(int health) {
        System.out.println(health);
    }

    public void IncreaseStamina(int stamina) {
        System.out.println(stamina);
    }

    public void DecreaseStamina(int stamina) {
        System.out.println(stamina);
    }
}

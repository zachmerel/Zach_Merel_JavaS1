package com.trilogyed;

public class Warrior extends Character {
    private int shieldStrength;

    public Warrior(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength) {
        super("Warrior Tim", 75, 100, 100, 50, 10);
        this.shieldStrength = shieldStrength;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public void DecreaseShieldStrength(int shieldStrength) {
        System.out.println(shieldStrength);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getStrength() {
        return super.getStrength();
    }

    @Override
    public void setStrength(int strength) {
        super.setStrength(strength);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public int getStamina() {
        return super.getStamina();
    }

    @Override
    public void setStamina(int stamina) {
        super.setStamina(stamina);
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }

    @Override
    public void setSpeed(int speed) {
        super.setSpeed(speed);
    }

    @Override
    public int getAttackPower() {
        return super.getAttackPower();
    }

    @Override
    public void setAttackPower(int attackPower) {
        super.setAttackPower(attackPower);
    }

    @Override
    public void Run(int speed) {
        super.Run(speed);
    }

    @Override
    public void Attack(int attackPower) {
        super.Attack(attackPower);
    }

    @Override
    public void Heal(int health) {
        super.Heal(health);
    }

    @Override
    public void DecreaseHealth(int health) {
        super.DecreaseHealth(health);
    }

    @Override
    public void IncreaseStamina(int stamina) {
        super.IncreaseStamina(stamina);
    }

    @Override
    public void DecreaseStamina(int stamina) {
        super.DecreaseStamina(stamina);
    }
}

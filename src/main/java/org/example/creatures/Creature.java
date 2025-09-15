package org.example.creatures;

import org.example.utils.Range;

import java.util.Random;

public abstract class Creature {
    private String name;
    private int attack;
    private int defense;
    private int hp;
    private int maxHp;
    private Range damage;

    public Creature(String name, int attack, int defense, int maxHp, Range damage) {
        if (attack < 1 || attack > 30)
            throw new IllegalArgumentException("Attack must be between 1 and 30");
        if (defense < 1 || defense > 30)
            throw new IllegalArgumentException("Defense must be between 1 and 30");
        if (maxHp < 0)
            throw new IllegalArgumentException("HP must be positive");
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public Range getDamage() {
        return damage;
    }

    public void setDamage(Range damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void receiveDamage(int dmg) {
        setHp(Math.max(0, getHp() - dmg));
    }

    public void toAttack(Creature target, Random rng) {
        int attackMod = getAttack() - target.getDefense() + 1;
        int diceCounter = Math.max(1, attackMod);
        boolean success = false;
        for (int i = 0; i < diceCounter; i++) {
            int roll = rng.nextInt(6) + 1;
            if (roll >= 5) {
                success = true;
                break;
            }
        }

        if (success) {
            int dmg = getDamage().getRandom(rng);
            target.receiveDamage(dmg);
            System.out.println(getName() + " hits " + target.getName() + ", dealing " + dmg + " damage!");
        } else {
            System.out.println(getName() + " misses " + target.getName() + "!");
        }
    }



}

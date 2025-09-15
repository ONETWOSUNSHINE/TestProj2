package org.example.creatures;

import org.example.utils.Range;

import java.util.Random;

public abstract class Creature {
    private final String name;
    private final int attack;
    private final int defense;
    private int hp;
    private final int maxHp;
    private final Range damage;

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

    public int getDefense() {
        return defense;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    protected void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void receiveDamage(int dmg) {
        hp = Math.max(0, getHp() - dmg);
    }

    public void attack(Creature target, Random rng) {
        int attackMod = attack - target.getDefense() + 1;
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
            int dmg = damage.getRandom(rng);
            target.receiveDamage(dmg);
            System.out.println(name + " hits " + target.getName() + ", dealing " + dmg + " damage!");
        } else {
            System.out.println(name + " misses " + target.getName() + "!");
        }
    }



}

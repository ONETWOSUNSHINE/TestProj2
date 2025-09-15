package org.example.creatures;

import org.example.utils.Range;

public class Player extends Creature {

    private int healCounter = 4;

    public Player(String name, int attack, int defense, int maxHp, Range damage) {
        super(name, attack, defense, maxHp, damage);
    }


    public void heal() {
        if (!isAlive()) {
            System.out.println(getName() + " is dead and cannot heal!");
            return;
        }
        if (healCounter <= 0) {
            System.out.println(getName() + " has no heals left!");
            return;
        }
        int healAmount = (int) (getMaxHp() * 0.3);
        setHp(Math.min(getMaxHp(), getHp() + healAmount));
        healCounter--;
        System.out.println(getName() + " restored " + healAmount + " hp! Heals left: " + healCounter);
    }
}

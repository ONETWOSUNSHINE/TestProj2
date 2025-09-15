package org.example;

import org.example.creatures.Monster;
import org.example.creatures.Player;
import org.example.utils.Range;

import java.util.Random;

public class App 
{
    public static void main( String[] args )
    {
        Random rng = new Random();
        Player hero = new Player("Hero", 15, 2, 30, new Range(4, 8));
        Monster goblin = new Monster("Goblin", 10, 4, 80, new Range(2, 6));
        System.out.println("=== Battle Start ===");
        System.out.println(hero.getName() + " vs " + goblin.getName());
        System.out.println(hero.getName() + " hp: " + hero.getHp());
        System.out.println(goblin.getName() + " hp: " + goblin.getHp());
        System.out.println();
        while (hero.isAlive() && goblin.isAlive()) {
            hero.attack(goblin, rng);
            System.out.println(hero.getName() + " hp: " + hero.getHp());
            System.out.println(goblin.getName() + " hp: " + goblin.getHp());
            if (!goblin.isAlive()) break;
            goblin.attack(hero, rng);
            System.out.println(hero.getName() + " hp: " + hero.getHp());
            System.out.println(goblin.getName() + " hp: " + goblin.getHp());
            if (hero.getHp() <= 20) {
                hero.heal();
            }
            System.out.println();
        }

        if (hero.isAlive()) {
            System.out.println(hero.getName() + " wins!");
        } else {
            System.out.println(goblin.getName() + " wins!");
        }
    }
}

package com.pluralsight;

public class SuperApp {
    public static void main(String[] args) {
        // Create a hero and villain
        SuperHero hero = new SuperHero("Captain Code", 100, 5);
        System.out.println(hero.name +" is a " + hero.getType());

        SuperVillan villain = new SuperVillan("Bugzilla", 100, 6);
        System.out.println(villain.name + " is a " + villain.getType());

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~THE BATTLE BEGINS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        int round = 1;
        while (hero.isAlive() && villain.isAlive()) {
            System.out.println("\n------------------------ Round " + round + " ----------------------------");

            // Hero attacks villain
            hero.fight(villain);
            hero.addPowerUp("glove", 10); // add power up for next rounds
            System.out.println(villain.getStatus());

            // Check if villain is still alive
            if (!villain.isAlive()) break;

            // Villain attacks hero
            villain.fight(hero);
            villain.addPowerUp("trap", 7); // add power up for next rounds
            System.out.println(hero.getStatus());

            round++;
        }

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~BATTLE OVER ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        if (hero.isAlive()) {
            System.out.println(hero.name + " wins the battle!");
        } else {
            System.out.println(villain.name + " wins the battle!");
        }
        hero.printBattleLog();
        villain.printBattleLog();
    }
}

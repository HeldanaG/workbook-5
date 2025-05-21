package com.pluralsight;

import java.util.Random;

public class SuperHero extends SuperPerson implements Fightable {

    public SuperHero(String name, int health, int powerLevel) {
        super(name, health);
        this.experiencePoints = powerLevel;

        System.out.println(this.name + " has arrived with a power level of " + powerLevel);
    }


        @Override
        public void fight(SuperPerson opponent){

            int bonus = getRandomPowerBonus(); // pulls from inventory
            int baseDamage = new Random().nextInt(12);
            int damage = baseDamage + this.experiencePoints + bonus;

            if (baseDamage ==0){
                System.out.println(this.name + " swings heroically ... but missed!");

            }else {
                System.out.println(this.name + " delivers a powerful blow for " + damage + " damage!");
                opponent.takeDamage(damage);
                logHit(opponent);
            }
    }


}
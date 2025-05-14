package com.pluralsight;

import java.util.Random;

//create a class using the extends keyword to bascially copy all the functionality from
//the parent class to the child class
public class SuperHero extends SuperPerson{

    //constructor that calls the parent class constructor
    public SuperHero(String name, int health, int powerLevel) {
        super(name, health);

        //in the parent we default power level (XP) to 0
        //for our superhero we want to have them pass in power level
        //but just use that as xp
        this.experiencePoints = powerLevel;

        //let the world know the hero now exists
        System.out.println(this.name + " has arrived with a power level of " + powerLevel);
    }


        @Override
        public void fight(SuperPerson opponent){

            int bonus = getRandomPowerBonus(); // pulls from inventory
            int baseDamage = new Random().nextInt(16);
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
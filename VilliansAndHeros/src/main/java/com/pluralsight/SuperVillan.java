package com.pluralsight;

import java.util.Random;

public class SuperVillan extends SuperPerson implements Fightable {

    public SuperVillan(String name, int health, int villianLevel){
        super(name, health);
        this.experiencePoints = villianLevel;
        System.out.println(this.name + " has arrived with a power level of " + villianLevel);
    }


    @Override
    public void fight(SuperPerson opponent){

        int bonus = getRandomPowerBonus(); // pulls from inventory
        int baseAttack = new Random().nextInt(9);
        int attack = baseAttack + this.experiencePoints + bonus;

        if (baseAttack ==0){
            System.out.println(this.name + " tries a sneaky attack... but missed!");

        }else {
            System.out.println(this.name + " unleashes chaos and deals " + attack + " damage to " + opponent.name + "!");
            opponent.takeDamage(attack);
            logHit(opponent);
        }
    }


}

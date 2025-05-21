package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class SuperPerson implements Fightable  {

    //protected properties so they can possibly be access by our children, grand children, etc...
    //these properties stay in the family
    protected String name;
    protected int health;
    protected int experiencePoints;

    protected HashMap<String, Integer> battleLog = new HashMap<>();
    // Power-up inventory: item name → bonus damage
    protected HashMap<String, Integer> inventory = new HashMap<>();

    public SuperPerson(String name, int health) {
        //take in the values for name and health
        this.name = name;
        this.health = health;

        //default the experience points to 0
        this.experiencePoints = 0;
    }

    //method to return if our SuperPerson is alive
    public boolean isAlive(){
        //if the health is greater than zero, return true, otherwise return false;
        return this.health > 0;

    }

    //method that allows us to fight another SuperPerson
    public abstract void fight(SuperPerson opponent);

    public String getType(){
        return this.getClass().getSimpleName();
    }

    //this methods allows a super person to take damage
    public void takeDamage(int damageAmount){
        //subtract the damage amount from the health
        //but we don't want ever set our health below 0
        this.health -= damageAmount;
        if(this.health < 0){
            this.health = 0;
        }
    }

    //a way to ask the super person how they are doing.
    public String getStatus(){

        //build and return a string that tells us how the SuperPerson is doing
        return this.name + " has " + this.health + " health left!";

    }

    //This method records one hit against a specific opponent.
    public void logHit(SuperPerson opponent) {
        String name = opponent.name;

        //This line checks if the battleLog already contains a hit count for a given opponent name.
        //If the opponent's name exists in the HashMap, it returns the current count
        //If the opponent's name is not in the map, it returns the default value 0
        // the first time you hit someone, there’s no entry yet in the map.
        //This avoids a NullPointerException, and makes sure you always have a valid number (starting from 0).
        int count = battleLog.getOrDefault(name, 0);  // Check how many times I've hit this person already — if never, start from 0
        battleLog.put(name, count + 1);
    }

    //This method prints out everyone this SuperPerson has hit and how many times.
    public void printBattleLog() {
        System.out.println("Battle log for " + name + ":");
        //battleLog.entrySet()	Returns a set of all key-value pairs in the map
        //HashMap.Entry<String, Integer> -is one of those key-value pairs. also	Represents each pair in the map (like "Bugzilla" → 3)
        //When you loop over the entire map, each item you loop over is an Entry.
        for (HashMap.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }


    // Add a new power-up to the inventory
    public void addPowerUp(String item, int value) {
        inventory.put(item, value);
    }

    // Get a random power-up bonus value (if inventory is not empty)
    public int getRandomPowerBonus() {
        if (!inventory.isEmpty()) {
            //create a new list of just the keys from the HashMap (glove, hammer, etc....)
            ArrayList<String> items = new ArrayList<>(inventory.keySet());
            //get a random item name from the above list we just made and store it in randomeItem
            String randomItem = items.get(new Random().nextInt(items.size()));
            System.out.println(this.name + " activated power-up: " + randomItem);
            return inventory.get(randomItem);
        }
        return 0; // no bonus if inventory is empty
    }



    //Concept	Meaning
    //HashMap	A container of key-value pairs
    //Entry<K, V>	One key-value pair inside the map
    //entrySet()	A set (list) of all entries in the map
    //entry.getKey()	The key (like a name)
    //entry.getValue()	The value (like a count)
}
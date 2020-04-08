package com.company.java101.oop;

public class FelineFamily extends Animal {
    private animalDangerLevel animalInclination = animalDangerLevel.EATHUMANS;
    public static String parent = "I am parent";
    protected String animalFoodType = "Carnivorous";

    int legs = 4;
    int tail = 1;
    boolean whiskers = true;

    int getLegs() {
        return legs;
    }

    int getTail() {
        return tail;
    }

    boolean getWhiskers() {
        return whiskers;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }


    @Override
    public void sound() {
        System.out.println("roar");
    }
    // the compiler gave  an error when i didn't define the 'eats' method here. Because unlike my Animal class, this is a concrete class.
    //    and any interface it inherits from an abstract class or any interface it implements needs to be defined here properly.
    @Override
    public void eats() {
        System.out.println("it has eaten");
    }
}

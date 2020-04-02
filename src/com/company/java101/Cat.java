package com.company.java101;

import org.relaxng.datatype.DatatypeException;

import java.util.ArrayList;

enum animalDangerLevel {
    EATHUMANS,
    MANIPULATIVE,
}

public class Cat extends FelineFamily {

    //    we can create object of Feline Family
    FelineFamily myParent = new FelineFamily();

//    abstract classes can only be inherited and their implementation can be used. We cant create object of Abstract classes.
//    Gives compile time error

//    Animal myTree = new Animal();

    //   The appetite of cats can't be defined in Integer as they're always hungry
    long appetite = 33333333333333L;

    String[] oldToys = new String[4];
    ArrayList<String> toys = new ArrayList<String>();

    @Override
    public void sound() {
        System.out.println("Moew");
    }

    @Override
    boolean getWhiskers() {
        return false;
    }

    @Override
    int getTail() {
        int tail = super.getTail();
        if (tail == 1) {
            System.out.println("Hurray a tail");
        }
        else {
            System.out.println("Sad. No tail");
        }
        return tail;
    }

    public void showCatBehaviour() {
//        Using parent method without owning it, because it automatically belongs us
        System.out.println("Cat has " + getLegs());

//        we override parent method, using parent implementation we make a decision but dont necessarily use the returned result
        getTail();
//        we override and replace the parent functionality completely. Notice I overrided the already overridden parent property.
        System.out.println("Cat has no whiskers " + getWhiskers());
//        We can use parent's food type as it is protected and can be used by child or same package
        System.out.println("Cat is " + animalFoodType);

//        we can't use parent's animal inclination level as it is private to parent. using it will create an compile time error
//        System.out.println("Cat is  " + animalInclination);

//        Using static variable with object instead of class didn't throw error. But!
//        Since the static variable is the same across all class objects/instances. Therefore,
//        Change the variable value in UnderstandingJava class showed changed value here.
        System.out.println(myParent.parent);

        System.out.println("Appetitie of a cat is " + appetite);
    }

    //    Arrays example
    public void setOldToys() {
        oldToys[0] = "Ruined scratching post";
        oldToys[1] = "My feelings";
        oldToys[2] = "All the love I could give my cat";
        oldToys[3] = "";
    }

    public void showOldToys() {
        System.out.println("Old toys of cat");
        int i = 0;
        while (i < oldToys.length) {
            System.out.println(oldToys[i]);
            i++;
        }
    }

    // ArrayList example
    public void addToys(String toy) {
        this.toys.add(toy);
    }

    public void catToys() {
        for(int i =0; i < toys.size(); i++) {
            System.out.println(toys.get(i));
        }
    }
}

class FelineFamily extends Animal {
    private animalDangerLevel animalInclination = animalDangerLevel.EATHUMANS;
    static String parent = "I am parent";
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

abstract class Animal implements Species {
    public abstract void sound();
    public void sleep(String animal) {
        System.out.println(animal + " is asleep now.");
    }
    //    let's notice how we implemented the interface in an abstract class yet we didnt define the 'eats' method here.
    //    Neither did the compiler give error. Because abstract classes dont necessarily have to define all methods inside themselves.
    //    We'll see above how Animal class is forced to implement 'eats' definition.
}

//can't inherit classes with final keywords. Helps when you dont want unintentionally to implement this behaviour in some other class.
//Ex: FelineFamily can't mutate themselves, neither can dogs or cats. Only humans or nature mutate them after considering certain aspects
final class MutateAnimal {

    void mutateLegs(FelineFamily feline) throws DatatypeException {
        int newLegs = 3;
        // In case a dog decides to mask itself as a cat or any other feline.
        if (feline instanceof Dog) {
            throw new DatatypeException("This method only mutates Feline Families");
        }
        else {
            System.out.println("Access granted - You are old enough!");
        }
        feline.setLegs(newLegs);
        String formattedString = String.format("Now cat has %d legs",  newLegs);
        System.out.println(formattedString);
    }
}


interface Species {
    void eats();
}

class Dog extends FelineFamily {}


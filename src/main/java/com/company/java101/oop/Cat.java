package com.company.java101.oop;

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

}

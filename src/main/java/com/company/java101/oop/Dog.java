package com.company.java101.oop;

abstract class Animal implements Species {
    public abstract void sound();
    public void sleep(String animal) {
        System.out.println(animal + " is asleep now.");
    }
    //    let's notice how we implemented the interface in an abstract class yet we didnt define the 'eats' method here.
    //    Neither did the compiler give error. Because abstract classes dont necessarily have to define all methods inside themselves.
    //    We'll see above how Animal class is forced to implement 'eats' definition.
}

interface Species {
    void eats();
}

public class Dog extends FelineFamily {
}
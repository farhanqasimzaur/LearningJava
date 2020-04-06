package com.company.java101.oop;

import com.company.java101.InvalidSpecification;
import com.company.java101.InvalidTypeException;
import sun.jvm.hotspot.utilities.AssertionFailure;

//can't inherit classes with final keywords. Helps when you dont want unintentionally to implement this behaviour in some other class.
//Ex: FelineFamily can't mutate themselves, neither can dogs or cats. Only humans or nature mutate them after considering certain aspects
final public class MutateAnimal {

    public void mutateLegs(FelineFamily feline, Integer legs) throws InvalidSpecification {
        // In case a dog decides to mask itself as a cat or any other feline.
        if (feline instanceof Dog) {

            throw new InvalidSpecification(feline, Cat.class);
        }
        else {
            feline.setLegs(legs);
            String formattedString = String.format("Now cat has %d legs",  legs);
            System.out.println(formattedString);
        }
    }

    public void mutateSound(String sound)  {
        if (sound.length() == 0) {
            throw new InvalidTypeException("Animal cant be without sound");
        }
    }
}

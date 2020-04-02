package com.company;

import com.company.java101.UnderstandingJava;

public class Main {

    public static void main(String[] args) {
        UnderstandingJava myLearning = new UnderstandingJava();
        myLearning.showCat();
        myLearning.mutateCat(myLearning.cat);
        System.out.println("");
        myLearning.mutateCat(myLearning.dog);
        System.out.println("");
        myLearning.cat.addToys("stuffed mouse");
        myLearning.cat.addToys("electronic cockroach");
        myLearning.cat.catToys();
        System.out.println("");
        myLearning.cat.setOldToys();
        myLearning.cat.showOldToys();

        myLearning.setPets();
        myLearning.removePet(myLearning.newCat);
        myLearning.showPets();

        myLearning.disownAllPets();
        myLearning.showPets();

        myLearning.generics();

    }
}

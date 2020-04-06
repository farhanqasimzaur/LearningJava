package com.company;

import com.company.java101.CollectionsExample;
import com.company.java101.UnderstandingJava;
import com.company.java101.oop.Frog;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        UnderstandingJava myLearning = new UnderstandingJava();
        myLearning.showCat();

        System.out.println("");
        myLearning.cat.addToys("stuffed mouse");
        myLearning.cat.addToys("electronic cockroach");
        myLearning.cat.catToys();
        System.out.println("");
        myLearning.cat.setOldToys();
        myLearning.cat.showOldToys();

        myLearning.generics();
        System.out.println("");
        myLearning.mutateCat(myLearning.cat, 3);
        myLearning.mutateCat(myLearning.dog, 2);
        Frog frog = new Frog();
        myLearning.mutateCat(frog, null);
        myLearning.mutateSound("");

        System.out.println("");
        CollectionsExample collection = new CollectionsExample();
    }
}

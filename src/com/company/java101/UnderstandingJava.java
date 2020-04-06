package com.company.java101;

import com.company.java101.oop.*;
import java.util.ArrayList;

public class UnderstandingJava {
    public FelineFamily myParent;
    public Cat cat;
    MutateAnimal mutate;
    public Dog dog = new Dog();


//    anything we need to do whilst initializing the class.
    public UnderstandingJava() {
        myParent = new FelineFamily();
        cat = new Cat();
        mutate = new MutateAnimal();
        System.out.println(myParent.parent);
//        changing static variable's value.
        myParent.parent = "I changed your parent. HAHA";
        System.out.println(myParent.parent);

    }

//    OOP
    public void showCat() {
        cat.showCatBehaviour();
    }

    //    Generics example
    public void generics() {
        Generics<Integer> intergerGeneric = new Generics<Integer>();
        intergerGeneric.set(1);
//        setting char in our integerGeneric would throw a compiler error because we already descriped that its a Integer Generic
//        intergerGeneric.set('2');
//        this would return us an integer value because we have sent an integer value
        intergerGeneric.get();


//        But at the same time we can create another generic object and provide it type String.
        Generics<String> stringGeneric = new Generics<String>();
        stringGeneric.set("hello Generics");
        //        this would return us a string value because we have sent a string value
        intergerGeneric.get();

//        Generics Arrays
//        ArrayList is a Generic type array. When I used this before I specified it's type to be String so it expected Strings
//        But here I gave it no type. Therefore this Array list would take any type of data
        ArrayList list = new ArrayList();

        list.add(1);
        list.add("d");

//        ArrayList is an unbounded Generic, allows all and any type of type. So is Generics class
//        But BoundedGenerics class only takes numbers, so even tho I didnt specify a type to the object.
        BoundedGenerics numberGeneric = new BoundedGenerics();
        numberGeneric.set(2);
        numberGeneric.set(3.4);

//      Therefore compiler gives error when I try to set a char to the function. Automatically all properties type of BoundedGenerics becomes Number
//        numberGeneric.set("s");

    }

//    Exceptions
    public void mutateCat(FelineFamily feline, Integer legs) {
//        notice how the actual method has FelineFamily as its Type. Yet we passed Cat objec to it.
//        that's because cat inherits Feline family and becomes FelineType as well as being Cat type.
        try {
            mutate.mutateLegs(feline, legs);
        } catch (InvalidTypeException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Cleaning up the lab after mutation experiment whether it failed or not.");
        }
    }

    public void mutateSound(String word) {
        mutate.mutateSound(word);
    }
}

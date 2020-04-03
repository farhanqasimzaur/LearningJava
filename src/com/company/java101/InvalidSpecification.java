package com.company.java101;

public class InvalidSpecification extends Exception {

    public InvalidSpecification(String error) {
        super(error);
    }

    public InvalidSpecification(Object object, Class c) {
        super("Only mutates type " + c + "Found object of Type " + object.getClass());
    }
}

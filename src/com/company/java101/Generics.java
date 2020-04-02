package com.company.java101;

public class Generics<T> {

    private T t;
    public void set(T t) { this.t = t; }
    public T get() { return t; }
}

class BoundedGenerics<T extends Number> {

    private T t;
    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
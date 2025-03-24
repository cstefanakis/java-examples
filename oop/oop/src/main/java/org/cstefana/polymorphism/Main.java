package org.cstefana.polymorphism;
//It allows one interface to be used for multiple implementations, meaning that a single method,
// function, or operator can behave differently based on the object it is acting upon.
class A {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        A object = new A();
        System.out.println(object.add(1, 2));
        System.out.println(object.add(1, 2, 1));
    }
}

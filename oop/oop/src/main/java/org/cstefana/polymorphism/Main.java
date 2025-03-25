package org.cstefana.polymorphism;


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


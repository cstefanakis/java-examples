package org.cstefana.superMethod;

class A {
    public A() {
        System.out.println("Class A without number");
    }

    public A(int a) {
        System.out.println("Class A with number " + a);
    }
}

class B extends A {
    public B() {
        System.out.println("Class B without number");
    }

    public B(int a) {
        this();
        System.out.println("Class B with number " + a);
    }
}

public class Main {
    public static void main(String[] args) {
        new B(5);
    }
}

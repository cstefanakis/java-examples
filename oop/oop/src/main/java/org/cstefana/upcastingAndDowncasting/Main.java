package org.cstefana.upcastingAndDowncasting;

class A {
    A() {
    }

    public void show1() {
        System.out.println("in A object");
    }
}

class B extends A {
    B() {
    }

    public void show2() {
        System.out.println("in B object");
    }
}

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        A objectOne = new B();
        objectOne.show1();
        B objectTwo = (B)objectOne;
        objectTwo.show2();
    }
}
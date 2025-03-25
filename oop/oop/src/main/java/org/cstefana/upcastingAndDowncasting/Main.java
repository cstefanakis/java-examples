package org.cstefana.upcastingAndDowncasting;

class A {

    public void show1() {
        System.out.println("in A object");
    }
}

class B extends A {

    public void show2() {
        System.out.println("in B object");
    }
}

public class Main {
    public static void main(String[] args) {
        A objectOne = new B();
        objectOne.show1();
        B objectTwo = (B)objectOne;
        objectTwo.show2();
    }
}
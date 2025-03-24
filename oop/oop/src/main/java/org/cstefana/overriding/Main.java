package org.cstefana.overriding;

class Calc {
    public int add(int a, int b) {
        return a + b;
    }
}

//Overriding the method
class AdvCalc extends Calc {
    public int add(int a, int b) {
        return a + b + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Calc calc = new AdvCalc();
        System.out.println(calc.add(1, 1));

        Calc calcTwo = new Calc();
        System.out.println(calc.add(1, 1));
    }
}

package org.cstefana.inheritance;

class Calc {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}

//inheritance
class AdvCalc extends Calc {
    public double divide(double a, double b) {
        return a / b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }
}

//multiple inheritance not exist but you call something like this
class SuperAdvCalc extends AdvCalc {
    public double root(double a){
        return Math.sqrt(a);
    }
}

public class Main {
    public static void main(String[] args) {

        Calc calc = new Calc();
        System.out.println(calc.add(1, 2));
        System.out.println(calc.sub(1, 2));

        AdvCalc advCalc = new AdvCalc();
        System.out.println(advCalc.add(1, 2));
        System.out.println(advCalc.sub(1, 2));
        System.out.println(advCalc.multiply(1, 2));
        System.out.println(advCalc.divide(2, 2));

        SuperAdvCalc superAdvCalc = new SuperAdvCalc();
        System.out.println(superAdvCalc.add(1, 2));
        System.out.println(superAdvCalc.sub(1, 2));
        System.out.println(superAdvCalc.multiply(1, 2));
        System.out.println(superAdvCalc.divide(2, 2));
        System.out.println(superAdvCalc.root(2));
    }
}

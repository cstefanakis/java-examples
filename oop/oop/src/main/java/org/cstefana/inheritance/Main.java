package org.cstefana.inheritance;

class Calc {
    Calc() {
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}

class AdvCalc extends Calc {
    AdvCalc() {
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }
}

class SuperAdvCalc extends AdvCalc {
    SuperAdvCalc() {
    }

    public double root(double a) {
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
        System.out.println(advCalc.multiply((double)1.0F, (double)2.0F));
        System.out.println(advCalc.divide((double)2.0F, (double)2.0F));

        SuperAdvCalc superAdvCalc = new SuperAdvCalc();
        System.out.println(superAdvCalc.add(1, 2));
        System.out.println(superAdvCalc.sub(1, 2));
        System.out.println(superAdvCalc.multiply((double)1.0F, (double)2.0F));
        System.out.println(superAdvCalc.divide((double)2.0F, (double)2.0F));
        System.out.println(superAdvCalc.root((double)2.0F));
    }
}

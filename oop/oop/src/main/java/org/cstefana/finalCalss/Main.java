package org.cstefana.finalCalss;

class Number {
    //if final cou cant change the variable
    final int finalNumber = 5;
}

final class Calculator {
    public void print(){

    }
}

//you can not extend Calculator because is final
/*class AdvCalc extends Calculator{}*/

public class Main {
    public static void main(String[] args) {

        Number number = new Number();
        /*number.finalNumber = 0; get error because is final.*/


    }
}

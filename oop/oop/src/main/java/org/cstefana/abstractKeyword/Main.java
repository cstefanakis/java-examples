package org.cstefana.abstractKeyword;


abstract class Car{

    //abstract method mast have abstract class
    public abstract void drive();

    public void playMusic(){
        System.out.println("play music");
    }
}


class WagonR extends Car{

    @Override
    public void drive() {
        System.out.println("in drive");
    }
}

public class Main {
    public static void main(String[] args) {
        Car obj = new WagonR();
        obj.drive();
        obj.playMusic();
    }
}

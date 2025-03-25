package org.cstefana.abstractKeyword;


abstract class Car{

    //abstract method mast have abstract class
    public abstract void drive();

    public abstract void run();

    public void playMusic(){
        System.out.println("play music");
    }
}


abstract class WagonR extends Car{

    @Override
    public void drive() {
        System.out.println("in drive");
    }
}

class UpdatedWagonR extends WagonR{

    @Override
    public void run() {
        System.out.println("in run");
    }
}

public class Main {
    public static void main(String[] args) {
        Car obj = new UpdatedWagonR();
        obj.drive();
        obj.playMusic();
        obj.run();
    }
}

package org.cstefana.innerClass;

class A {
        public void show()
        {
            System.out.println("in show");
        }
    class B {
        public void config(){
            System.out.println("in config");
        }
    }

    static class C {
        public void play(){
            System.out.println("in play");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

        //inner class call with this way.
        A.B obj2 = obj.new B();
        obj2.config();

        //inner class if is static
        A.C obj3 = new A.C();
        obj3.play();

    }
}

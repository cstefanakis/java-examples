package org.cstefana.innerClass.anonymous;

class A {
    public void show()
    {
        System.out.println("in show");
    }
}

public class Main {
    public static void main(String[] args) {

        A obj = new A()
                //there build an anonymous inner class
        {
            public void show()
            {
                System.out.println("in new show");
            }
        };

        obj.show();

        A obj2 = new A();
        obj2.show();
    }
}

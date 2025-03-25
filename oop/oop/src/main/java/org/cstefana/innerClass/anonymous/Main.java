package org.cstefana.innerClass.anonymous;

class A {
    int age;
    public void show()
    {
        System.out.println("in show");
    }
}

public class Main {
    public static void main(String[] args) {
        //there build an anonymous inner class
        A obj = new A()
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

package org.perscholas.m_303_3;

public class WrapperClassesExample {

    public static void booleanAutobox(boolean b){
        System.out.println("Function called with " + b);
    }

    public static void autobox(Integer x) {
        System.out.println("Function called with " + x);
    }

    public static void main(String[] args) {
        int x = 5;

        // this is autoboxing - the compiler / JVM will auto convert between the primitive and wrapper class
        Integer y = x;

        // this is manually converting a primitive int to a wrapper class
        Integer z = Integer.valueOf(x);

        // call the function
        autobox(5);
        autobox(x);
        autobox(y);

        // all java objects can be null
        Integer value = null;

        // a primitive can not be null
        // int v1 = null;

        Boolean b1 = true;
        boolean b2 = false;

        booleanAutobox(b1);
        booleanAutobox(b2);

        String s1 = "String";

        char c = 'c';
    }
}

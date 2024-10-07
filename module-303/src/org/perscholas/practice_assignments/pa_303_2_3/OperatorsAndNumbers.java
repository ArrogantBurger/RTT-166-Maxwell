package org.perscholas.practice_assignments.pa_303_2_3;

public class OperatorsAndNumbers {

    static void Program1(int input) {
        int x = input;
        System.out.println(Integer.toBinaryString(x));

        // left shift operator multiplies x * 2^n, where n = 1
        // expect value of x to double after the operation
        x <<= 1;
        System.out.println("Decimal value: " + x + ", Binary string: " + Integer.toBinaryString(x));
    }

    static void Program2(int input){
        int x = input;
        System.out.println(Integer.toBinaryString(x));

        // right shift operator divides x / 2^n, where n = 2
        // expect value of x to quarter after the operation
        x >>= 2;
        System.out.println("Decimal value: " + x + ", Binary string: " + Integer.toBinaryString(x));
    }

    static void Program3(){

        // bitwise 00111
        int x = 7;
        // bitwise 10001
        int y = 17;
        // expecting 00001
        int z = x & y;


        System.out.println("Decimal value: " + z + ", Binary string: " + Integer.toBinaryString(z));
    }

    static void Program4(){

        // bitwise 00111
        int x = 7;
        // bitwise 10001
        int y = 17;
        // expecting 10111
        int z = x | y;


        System.out.println("Decimal value: " + z + ", Binary string: " + Integer.toBinaryString(z));
    }

    static void Program5(int input){
        int x = input;
        System.out.println(x);

        System.out.println("Standard increment");
        x = x + 1;
        System.out.println(x);
        x = x + 1;
        System.out.println(x);
        x = input;

        //prefix increment
        System.out.println("Prefix increment");
        ++x;
        System.out.println(x);
        ++x;
        System.out.println(x);
        x = input;

        //postfix increment
        System.out.println("Postfix increment");
        x++;
        System.out.println(x);
        x++;
        System.out.println(x);
    }

    static void Program6(){
        int x = 5;
        int y = 8;
        System.out.println("Prefix increment");
        int sum = ++x + y;
        System.out.println(sum);
        System.out.println("Postfix increment");
        sum = x++ + y;
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Program1(9);
        Program1(17);
        Program1(88);

        Program2(225);
        Program2(1555);
        Program2(32456);

        Program3();
        Program4();
        Program5(10);
        Program6();
    }
}

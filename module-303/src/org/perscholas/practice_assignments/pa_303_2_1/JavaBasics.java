package org.perscholas.practice_assignments.pa_303_2_1;

import java.text.DecimalFormat;

public class JavaBasics {

    // Declares two integer variables, assigns an integer to each, and adds them together
    static int IntegerSum(int input1, int input2) {
        return input1 + input2;
    }

    // Declares two double variables, assigns a double to each, and adds them together
    static double DoubleSum(double input1, double input2) {
        return input1 + input2;
    }

    static double IntDoubleSum(int input1, double input2){
        double output = input1 + input2;
        return output;
    }

    static int IntegerDivision(int input1, int input2) {
        return input1 / input2;
    }

    static double DoubleDivision(double input1, double input2) {
        return input1 / input2;
    }

    static double IntDoubleDivision(int input1, double input2){
        double output = input1 / input2;
        return output;
    }

    static void Program1(){
        int x = 5;
        int y = 6;

        double q = y/x;
        System.out.println(q);

        q = (double)y / x;
        System.out.println(q);
    }

    // uses a constant to calculate diameter of a circle
    static void Program2(double input) {
        final double pi = 3.14159d;
        System.out.println(input * pi);
    }

    static void Program3(){
        double juice = 2.35d;
        double coffee = 3.5d;
        double milk =  2d;

        double subtotal;
        double totalSale;

        final double SALES_TAX = 1.0825;
        DecimalFormat formatter = new DecimalFormat("#0.00");

        subtotal = (3 * juice) + (4 * coffee) + (2 * milk);
        totalSale = subtotal * SALES_TAX;
        System.out.println(formatter.format(totalSale));
    }

    public static void main(String[] args) {
        System.out.println(IntegerSum(10, 5));
        System.out.println(DoubleSum(10d, 5d));
        System.out.println(IntDoubleSum(10, 5d));

        System.out.println(IntegerDivision(10, 5));
        System.out.println(DoubleDivision(10d, 5d));
        System.out.println(IntDoubleDivision(10, 5d));

        Program1();
        Program2(5d);
        Program3();
    }
}

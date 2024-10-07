package org.perscholas.m_303_4;

public class IfStatementsExample {
    public static void main(String[] args) {

        double radius = 10;

        if (radius > 20) {
            System.out.println("Radius greater than 20");
        } else if (radius > 10) {
            System.out.println("Radius greater than 10");
        } else {
            System.out.println("Radius less than or equal to 10");
        }

        // grades

        double grade = 30;

        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80){
            System.out.println("B");
        } else if (grade >= 70){
            System.out.println("C");
        } else if (grade >= 60){
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}

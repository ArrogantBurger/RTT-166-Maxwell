package org.perscholas;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        System.out.print("Enter the radius of the circle: ");

        Scanner scanner = new Scanner(System.in);

        // after scanning a number we need to do a scanner.nextLine() to throw
        // the newLine character (which was created when you pressed enter on the keyboard
        // into the garbage
        // IMPORTANT

        double x = scanner.nextDouble();

        System.out.println("You have entered a radius of " + x);

        double area = x * x * 3.14159;

        System.out.println("The area of the circle is " + area);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

    }

}

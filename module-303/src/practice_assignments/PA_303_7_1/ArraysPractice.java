package practice_assignments.PA_303_7_1;

import java.util.*;

class ArraysContainer {

    // create array with length of 3
    void task1() {
        System.out.println("Task 1");
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // returns the middle element in an array
    int task2() {
        System.out.println("Task 2");
        int[] array = {13, 5, 7, 68, 2};
        // odd number of elements
        if (array.length % 2 == 1 || array.length != 0) {
            return array[(array.length / 2)];
        }
        // even number of elements
        else if (array.length % 2 == 0 || array.length != 0) {
            return array[array.length / 2];
        }
        // array has no elements
        else {
            return -1;
        }
    }

    // create several strings in an array and print the array length
    // copy array w/ clone() method
    // use Arrays.toString() method on new array to verify copy
    void task3() {
        System.out.println("Task 3");
        String[] array = {"red", "green", "blue", "yellow"};
        System.out.println("Array has " + array.length + " elements");
        String[] array2 = clone(array);
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("Cloned array: " + Arrays.toString(array2));
    }

    String[] clone(String[] input) {
        String[] output = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i];
        }
        return output;
    }

    // Make an array with 5 elements and try to inject a value at array[5]
    // Should produce an exception
    void task4() {
        System.out.println("Task 4");
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        try {
            array[5] = 5;
        } catch (Exception e) {
            System.out.println("Expected outcome - out of bound error.");
        }
    }

    // Make an array with 5 elements, assigning values to each element using loop control variable i
    void task5() {
        System.out.println("Task 5");
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    // Make an array with 5 elements, assigning values to each element using loop control variable i * 2
    void task6() {
        System.out.println("Task 6");
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }
    }

    // Make an array with 5 elements, printing all but the middle element
    void task7() {
        System.out.println("Task 7");
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            if (i != array.length / 2) {
                System.out.println(array[i]);
            }
        }
    }

    // Make an String array of 5 elements, swap the first element with the middle element without creating a new array
    void task8() {
        System.out.println("Task 8");
        String[] array = {"red", "green", "blue", "yellow", "purple"};
        System.out.println("Before swap: " + Arrays.toString(array));
        String temp = array[0];
        array[0] = array[array.length / 2];
        array[array.length / 2] = temp;
        System.out.println("After swap: " + Arrays.toString(array));
    }

    // sort array in ascending order
    void task9() {
        System.out.println("Task 9");
        int[] array = {4, 2, 9, 13, 1, 0};
        System.out.println("Before sort: " + Arrays.toString(array));

        //sort array, bubble sort implementation
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        System.out.println("After sort: " + Arrays.toString(array));
    }

    // Create array that contains an integer, 3 strings, and a double
    void task10() {
        System.out.println("Task 10");
        Object[] array = new Object[5];
        array[0] = 10;
        array[1] = "red";
        array[2] = "green";
        array[3] = "blue";
        array[4] = 3.14;

        for (Object element : array) {
            System.out.println(element);
        }
    }

    // Asks user for number of favorite things then accepts number of strings equal to first answer
    // Injects strings into array, then prints the contents
    void task11() {
        System.out.println("Task 11");
        Scanner sc = new Scanner(System.in);

        System.out.print("How many favorite things do you have? ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your thing: ");
            array[i] = sc.nextLine();
        }

        for (String element : array) {
            System.out.println(element);
        }
    }
}

public class ArraysPractice {

    public static void main(String[] args) {
        ArraysContainer a = new ArraysContainer();
        a.task1();
        System.out.println(a.task2());
        a.task3();
        a.task4();
        a.task5();
        a.task6();
        a.task7();
        a.task8();
        a.task9();
        a.task10();
        a.task11();
    }

}

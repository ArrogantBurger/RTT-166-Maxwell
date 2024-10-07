package org.perscholas.m_303_5;

public class LoopsExample {

    public static void main(String[] args) {

        // this is the original 1970s for loop, and it works great for when you want to count
        // or do something a set number of times
        // this is also good for positioning within an array or string

        // counting up
        for (int count = 0; count < 10; count++) {
            System.out.println("For loop iteration " + count);
        }

        // count down
        for (int count = 0; count >= 1; count--) {
            System.out.println("For loop iteration " + count);
        }

        // the array is 0 based... this means the positions in the array are from 0 to 4
        String[] strings = {"one", "two", "three", "four", "five"};

        // old style for loop
        for (int position = 0; position < strings.length; position++) {
            System.out.println("strings at position " + position + " = " + strings[position]);
        }

        // looping over the characters in a string
        //                   0123456
        String characters = "abcdefg";

        for (int position = 0; position < characters.length(); position++) {
            System.out.println("characters at position " + position + " = " + characters.charAt(position));
        }
    }
}

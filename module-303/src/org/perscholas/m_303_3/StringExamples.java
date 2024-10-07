package org.perscholas.m_303_3;

import java.util.StringJoiner;

public class StringExamples {

    public static void main(String[] args) {

        // the total length of the string is 6 characters

        // 0 based indexing
        //          0123456
        String s = "abcdef";

        // this will print the length of the string
        System.out.println("The length of the string is " + s.length());

        // this will print the string in upper case
        System.out.println("Uppercase = " + s.toUpperCase());

        // appends additional string to String s
        String concat = s.concat("ghijk");
        System.out.println(concat);

        System.out.println(s.charAt(0));
        System.out.println(s.charAt(5));
        System.out.println(concat.charAt(6)); // this will produce an error because there is no character in position 6

        String r = "abc123abc";
        // replace a with z
        System.out.println(r.replace('a', 'z'));

        // replace abc with xyz
        System.out.println(r.replace("abc", "xyz"));

        // replaceAll uses a regular expression
        System.out.println(r.replaceAll("\\d", "9"));

        // SUBSTRING
        //                 0123456789012
        String filename = "someimage.jpg";

        // this goes from position 0 to position 4 but does not include position 4
        System.out.println(filename.substring(0, 4));
        System.out.println(filename.substring(1, 5));

        // when we use a single argument w substring, it is simply the starting position and it will take the rest of the string
        System.out.println(filename.substring(4));

        // we want to print out the index of the . in the string
        System.out.println("The . is in position " + filename.indexOf("."));

        // so to get the file extension we can use a combination of substring and indexOF
        System.out.println(filename.substring(filename.indexOf(".")));

        // challenge
        System.out.println(filename.substring(0, filename.indexOf(".")));

        String s1 = new String("abc");
        String s2 = new String("ABC");

        // THIS IS ALWAYS INCORRECT AND WILL PRINT FALSE BECAUSE THEY POINT TO DIFFERENT AREAS IN MEMORY
        System.out.println(s1 == s2);

        // THIS IS THE CORRECT METHOD TO EQUATE STRINGS
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        // convert from string to number
        String n = "101";
        // this will take the string 101 and convert it to the number 101
        Integer n1 = Integer.parseInt(n);

        // this method can throw an exception because the string may not contain only numbers
        //Integer n3 = Integer.parseInt("1234abc");

        // converting from a number to a string is easy
        String n2 = n1.toString();

        // IMPORTANT - String in java is immutable
        String s4 = "abc";
        String s5 = "123";

        // when s4.toUppercase is called it creates a brand new string in memory that is assigned to variable s6
        // it did not modify s4, it creates a new string
        // then it concatenates on the string s5 when creating yet another new string in memory that is assigned to variable s6
        String s6 = s4.toUpperCase() + s5;

        // STRING BUFFERS

        // the StringBuffer is mutable meaning the internal content of the StringBuffer can be changed
        // when doing lots of string manipulation, the StringBuffer should be used to make memory managing more efficient
        StringBuffer sb = new StringBuffer();

        // append will add something to the end of the string and has the same effect as concat for strings
        sb.append("abc");
        sb.append("123");

        // know this for the KBA
        // this will start insert at position 4
        sb.insert(4, "xyz");

        // replace function for String Buffer
        sb.replace(0, 3, "ABCDEF");

        sb.delete(0,3);

        sb.reverse();

        // KBA question
        StringBuffer kba = new StringBuffer("ABC");
        kba.replace(0, 7, "DEFG");
        kba.insert(0, "12345");
        kba.reverse();
        kba.delete(0,5);

        System.out.println(sb.toString());

        // String Joiner

        StringJoiner joinNames1 = new StringJoiner("|", "{ ", "}");
        StringJoiner joinNames2 = new StringJoiner(":", "{ ", "}");

        joinNames1.add("Eric");
        joinNames1.add("Jessica");

        System.out.print(joinNames1.toString());

        joinNames2.add("Jeff");
        joinNames2.add("Kiet");

        System.out.println(joinNames2.toString());
    }
}

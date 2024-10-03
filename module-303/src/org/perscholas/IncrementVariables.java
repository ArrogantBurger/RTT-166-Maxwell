package org.perscholas;

public class IncrementVariables {
    public static void main(String[] args) {
         int a = 20;
         int b = 10;
         int c = 0;
         int d = 20;
         int e = 40;
         int f = 30;

         int result = -a; // result is now -20
         result = a * -1; // this is much more readable
         System.out.println(result); // -20

        c = b++;
        System.out.println("Value of c = (b++) : c = " + c + " and b = " + b);
        // c = 10 and b == 11

        c = ++a;
        System.out.println("Value of c = (++a) : c = " + c + " and a = " + a);
        //c = 21 and a = 21
    }
}

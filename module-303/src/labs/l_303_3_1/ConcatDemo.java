package labs.l_303_3_1;

public class ConcatDemo {
    public static void main(String[] args) {
        String str1 = "Learn ";
        String str2 = "Java ";

        System.out.println(str1.concat(str2));
        System.out.println(str2.concat(str1));

        String s3 = "hello";
        String s4 = "Learners";

        String s5 = s3 + s4;

        String message = "Welcome " + "to " + "Java";

        String s = "chapter " + 2;

        String s1 = "Supplement " + 'B';

        System.out.println("The first character in the message is " + message.charAt(0));
    }
}

package labs.l_303_3_1;

public class ReplaceDemoMain {
    public static void main(String[] args) {
        String str1 = "abc cba";

        System.out.println(str1.replace('a', 'z'));

        System.out.println("Lava".replace('L', 'J'));

        System.out.println("Hava".replace('4', 'J'));

        System.out.println(str1.replace("C++", "Java"));

        System.out.println("aa bb aa zz".replace("aa", "zz"));

        System.out.println("Java".replace("C++", "C"));

    }
}

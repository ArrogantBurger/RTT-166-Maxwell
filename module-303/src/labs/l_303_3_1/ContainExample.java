package labs.l_303_3_1;

public class ContainExample {
    public static void main(String[] args) {
        String str1 = "Learn Java";
        Boolean result;

        // check if str1 contains "Java"
        result = str1.contains("Java");
        System.out.println(result);

        result = str1.contains("Python");
        System.out.println(result);

        result = str1.contains("");
        System.out.println(result);
    }
}

package labs.l_303_3_1;

import java.util.Arrays;

public class SplitMethod {
    public static void main(String[] args) {
        String vowels = "a::b::c::d:e";

        String[] result = vowels.split("::");
        System.out.println("result = " + Arrays.toString(result));
    }
}

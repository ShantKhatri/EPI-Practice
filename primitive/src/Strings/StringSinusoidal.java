package Strings;

public class StringSinusoidal {

    public static String snackString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        for (int i = 2; i < s.length(); i += 4) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}

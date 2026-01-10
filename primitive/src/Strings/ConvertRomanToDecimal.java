package Strings;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToDecimal {
    public static int romanToInteger(String s) {
        Map<Character, Integer> T = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int sum = T.get(s.charAt(s.length()-1));
        for (int i = s.length()-2; i >= 0; --i) {
            if (T.get(s.charAt(i)) < T.get(s.charAt(i+1))) {
                sum -= T.get(s.charAt(i));
            } else {
                sum += T.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static String integerToRoman(int n) {

        if (n<=0 || n>3999) {
            throw new IllegalArgumentException("n must be between 1 and 3999");
        }
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] symbols = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while(n>=values[i]) {
                n -= values[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }

}

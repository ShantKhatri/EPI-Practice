import java.util.List;

public class IncrementDigitIntegerArray {
    static void test(String s, String t, String expected) {
        String actual = addBinary(s, t);
        if (!actual.equals(expected)) {
            System.out.println("❌ FAIL");
            System.out.println("s = " + s);
            System.out.println("t = " + t);
            System.out.println("expected = " + expected);
            System.out.println("actual   = " + actual);
            System.out.println();
        } else {
            System.out.println("✅ PASS: " + s + " + " + t + " = " + actual);
        }
    }

    public static void main(String[] args) {

        // 1. Basic tests
        test("0", "0", "0");
        test("0", "1", "1");
        test("1", "0", "1");
        test("1", "1", "10");

        // 2. Different lengths
        test("101", "11", "1000");
        test("1", "111", "1000");
        test("1010", "101", "1111");

        // 3. Carry propagation
        test("111", "1", "1000");
        test("1111", "1", "10000");
        test("101111", "1", "110000");

        // 4. Leading zeros
        test("0000", "0", "0");
        test("00101", "00011", "1000");
        test("0001", "0001", "10");

        // 5. Large input (breaks parseInt solutions)
        test(
                "11111111111111111111111111111111",
                "1",
                "100000000000000000000000000000000"
        );

        test(
                "1".repeat(50),
                "1",
                "1" + "0".repeat(50)
        );

        System.out.println("\nTests completed.");
    }

    static List<Integer> plusOne(List<Integer> A){
        int n = A.size();
        A.set(n, A.get(n) + 1);
        for(int i = A.size(); i>=0 && A.get(i) == 10; i++){
            A.set(i, 0);
            A.set(i-1, A.get(i-1)+1);
        }
        if(A.get(0) == 10){
            A.set(0, 0);
            A.add(0,A.get(1));
        }
        return A;
    }

    static String addBinary(String s, String t){
        StringBuilder result = new StringBuilder();

        int i = s.length()-1;
        int j = t.length()-1;
        int carry = 0;

        while(i>=0 || j >= 0 || carry > 0) {
            int sum = carry;

            if(i>=0) sum += s.charAt(i--) - '0';
            if(j>=0) sum += s.charAt(j--) - '0';

            result.append(sum%2);
            carry = sum/2;
        }

        return result.reverse().toString();
    }
}

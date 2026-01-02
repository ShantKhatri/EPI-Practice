import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultipleArrayDigitNum {
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        final int sign = (num1.get(0) < 0) ^ (num2.get(0) < 0) ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result =
                new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                result.set(i + j + 1,
                        result.get(i + j + 1) + num1.get(i) * num2.get(j));
                result.set(i + j,
                        result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1,
                        result.get(i + j + 1) % 10);
            }
        }

        int firstNotZero = 0;
        while (firstNotZero < result.size() && result.get(firstNotZero) == 0) {
            ++firstNotZero;
        }

        result = result.subList(firstNotZero, result.size());
        if (result.isEmpty()) return Arrays.asList(0);

        result.set(0, result.get(0) * sign);
        return result;
    }

    // ---------- test helpers ----------

    static List<Integer> list(int... digits) {
        List<Integer> res = new ArrayList<>();
        for (int d : digits) res.add(d);
        return res;
    }

    static void test(List<Integer> a, List<Integer> b, List<Integer> expected) {
        List<Integer> actual = multiply(new ArrayList<>(a), new ArrayList<>(b));
        if (!actual.equals(expected)) {
            System.out.println("❌ FAIL");
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("expected = " + expected);
            System.out.println("actual   = " + actual);
            System.out.println();
        } else {
            System.out.println("✅ PASS: " + a + " * " + b + " = " + actual);
        }
    }

    public static void main(String[] args) {

        // 1️⃣ Basic multiplication
        test(list(1,2,3), list(4,5), list(5,5,3,5));   // 123 * 45 = 5535
        test(list(9), list(9), list(8,1));             // 9 * 9 = 81
        test(list(1,0), list(1,0), list(1,0,0));       // 10 * 10 = 100

        // 2️⃣ Carry-heavy cases
        test(list(9,9), list(9,9), list(9,8,0,1));     // 99 * 99 = 9801
        test(list(9,9,9), list(9), list(8,9,9,1));     // 999 * 9 = 8991

        // 3️⃣ Zero handling
        test(list(0), list(1,2,3), list(0));           // 0 * 123 = 0
        test(list(0), list(0), list(0));               // 0 * 0 = 0

        // 4️⃣ Negative numbers
        test(list(-1,2,3), list(4,5), list(-5,5,3,5)); // -123 * 45
        test(list(-1,2,3), list(-4,5), list(5,5,3,5)); // -123 * -45
        test(list(1,2,3), list(-4,5), list(-5,5,3,5)); // 123 * -45

        // 5️⃣ Leading zeros
        test(list(0,0,1,2), list(0,3), list(3,6));     // 12 * 3 = 36

        // 6️⃣ Large numbers (string-style arithmetic)
        test(
                list(9,9,9,9,9),
                list(9,9,9,9,9),
                list(9,9,9,9,8,0,0,0,0,1)
        ); // 99999 * 99999 = 9999800001

        System.out.println("\nAll tests executed.");
    }
}

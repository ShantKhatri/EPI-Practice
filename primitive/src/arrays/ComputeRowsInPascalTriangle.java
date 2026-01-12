package arrays;

import java.util.ArrayList;
import java.util.List;

public class ComputeRowsInPascalTriangle {

    public static void main(String[] args) {

        System.out.println("Testing nthROwOfPascalTriangle:");

        System.out.println("n = 0  -> " + nthROwOfPascalTriangle(0));
        // Expected: []

        System.out.println("n = 1  -> " + nthROwOfPascalTriangle(1));
        // Expected: [1]

        System.out.println("n = 2  -> " + nthROwOfPascalTriangle(2));
        // Expected: [1, 1]

        System.out.println("n = 3  -> " + nthROwOfPascalTriangle(3));
        // Expected: [1, 2, 1]

        System.out.println("n = 4  -> " + nthROwOfPascalTriangle(4));
        // Expected: [1, 3, 3, 1]

        System.out.println("n = 5  -> " + nthROwOfPascalTriangle(5));
        // Expected: [1, 4, 6, 4, 1]

        System.out.println("\nTesting generatePascalTriangle:");

        System.out.println("numRows = 0");
        System.out.println(generatePascalTriangle(0));
        // Expected: []

        System.out.println("\nnumRows = 1");
        System.out.println(generatePascalTriangle(1));
        // Expected:
        // [[1]]

        System.out.println("\nnumRows = 2");
        System.out.println(generatePascalTriangle(2));
        // Expected:
        // [[1],
        //  [1, 1]]

        System.out.println("\nnumRows = 3");
        System.out.println(generatePascalTriangle(3));
        // Expected:
        // [[1],
        //  [1, 1],
        //  [1, 2, 1]]

        System.out.println("\nnumRows = 5");
        System.out.println(generatePascalTriangle(5));
        // Expected:
        // [[1],
        //  [1, 1],
        //  [1, 2, 1],
        //  [1, 3, 3, 1],
        //  [1, 4, 6, 4, 1]]
    }



    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                row.add((j>0 && j<i) ?
                        pascalTriangle.get(i-1).get(j-1)
                                + pascalTriangle.get(i-1).get(j)
                        : 1);
            }
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }

    public static List<Integer> nthROwOfPascalTriangle(int n) {
        List<Integer> lastRow = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                currRow.add((j>0 && j<i) ?
                        lastRow.get(j-1) + lastRow.get(j) : 1);
            }
            lastRow = currRow;
        }
        return lastRow;
    }
}

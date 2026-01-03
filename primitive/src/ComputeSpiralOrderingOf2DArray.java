import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeSpiralOrderingOf2DArray {

    public static void main(String[] args) {

        // Test case 1: n = 1 (minimum valid case)
        System.out.println("Test Case n = 1");
        printMatrix(createSpiralMatrix(1));
        // Expected:
        // 1

        // Test case 2: n = 2 (small even)
        System.out.println("\nTest Case n = 2");
        printMatrix(createSpiralMatrix(2));
        // Expected:
        // 1 2
        // 4 3

        // Test case 3: n = 3 (example given)
        System.out.println("\nTest Case n = 3");
        printMatrix(createSpiralMatrix(3));
        // Expected:
        // 1 2 3
        // 8 9 4
        // 7 6 5

        // Test case 4: n = 4 (even dimension)
        System.out.println("\nTest Case n = 4");
        printMatrix(createSpiralMatrix(4));
        // Expected:
        // 1  2  3  4
        // 12 13 14 5
        // 11 16 15 6
        // 10 9  8  7

        // Test case 5: n = 5 (larger odd)
        System.out.println("\nTest Case n = 5");
        printMatrix(createSpiralMatrix(5));

        // Test case 6: n = 0 (invalid input)
        System.out.println("\nTest Case n = 0");
        printMatrix(createSpiralMatrix(0));
        // Expected: empty matrix or handled gracefully

        // Test case 7: n = -3 (invalid input)
        System.out.println("\nTest Case n = -3");
        printMatrix(createSpiralMatrix(-3));
        // Expected: empty matrix or exception
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        if (matrix == null || matrix.isEmpty()) {
            System.out.println("[]");
            return;
        }
        for (List<Integer> row : matrix) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }

    public static List<Integer> matrixInSpriralOrder(List<List<Integer>> squareMatrix) {
        List<Integer> spiralOrdering = new ArrayList<>();
        for (int offset = 0; offset < (Math.ceil(0.5 * squareMatrix.size())); ++offset)
            matrixLayerInClockWise(squareMatrix, offset, spiralOrdering);
        return spiralOrdering;
    }

    public static List<Integer> matrixInSpriralOrderOpt(List<List<Integer>> squareMatrix) {
        List<Integer> spiralOrdering = new ArrayList<>();
        final int[][] SHIFT = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int dir = 0, x = 0, y = 0;

        for (int i = 0; i < squareMatrix.size() * squareMatrix.size(); ++i) {
            spiralOrdering.add(squareMatrix.get(x).get(y));
            squareMatrix.get(x).set(y, 0);
            int nextX = x + SHIFT[dir][0], nextY = y + SHIFT[dir][1];
            if (nextX < 0 || nextX >= squareMatrix.size() || nextY < 0
            || nextY <= squareMatrix.size() || squareMatrix.get(nextX).get(nextY) == 0) {
                dir = (dir + 1) % 4;
                nextX = x + SHIFT[dir][0];
                nextY = y + SHIFT[dir][1];
            }
            x = nextX;
            y = nextY;
        }
        return spiralOrdering;
    }

    private static void matrixLayerInClockWise (List<List<Integer>> squareMatrix, int offset, List<Integer> spiralOrdering) {
        if (offset == squareMatrix.size()-offset-1){
            // squareMatrix has odd dimensio and we are at centre
            spiralOrdering.add(squareMatrix.get(offset).get(offset));
            return;
        }
        for (int i = offset; i < squareMatrix.size()-offset-1; ++i) {
            spiralOrdering.add(squareMatrix.get(offset).get(i));
        }
        for (int i = offset; i < squareMatrix.size()-offset-1; ++i) {
            spiralOrdering.add(squareMatrix.get(i).get(squareMatrix.size()-offset-1));
        }
        for (int i = squareMatrix.size()-offset-1; i > offset ; --i) {
            spiralOrdering.add(squareMatrix.get(squareMatrix.size()-offset-1).get(i));
        }
        for (int i = squareMatrix.size()-offset-1; i > offset ; --i) {
            spiralOrdering.add(squareMatrix.get(i).get(offset));
        }
    }

    public static List<List<Integer>> createSpiralMatrix(int n) {
        if (n == 1)
            return Collections.singletonList(Collections.singletonList(1));
        if (n<=0)
            return Collections.emptyList();
        final int[][] SHIFT = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int dir = 0, x = 0, y = 0;
        List<List<Integer>> squareMatrix = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                row.add(0);
            }
            squareMatrix.add(row);
        }

        for (int i = 0; i < n*n; ++i) {
            squareMatrix.get(x).set(y, i+1);
            int nextX = x + SHIFT[dir][0], nextY = y + SHIFT[dir][1];
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n ||
                    squareMatrix.get(nextX).get(nextY) != 0) {
                dir = (dir+1)%4;
                nextX = x + SHIFT[dir][0];
                nextY = y + SHIFT[dir][1];
            }
            x = nextX;
            y = nextY;
        }
        System.out.println("SIZE: "+squareMatrix.size());
        return squareMatrix;
    }

    public static List<int[]> spiralPoints(int n) {
        List<int []> result = new ArrayList<>();
        if(n<=0) return result;

        int x = 0, y = 0;
        result.add(new int[]{x,y});
        if (n==1) return result;

        int [][] DIRS = {
                {1,0},
                {0,-1},
                {-1,0},
                {0,1}
        };

        int stepSize = 1;
        int dir = 0;

        while (result.size()<n) {
            for (int repeat = 0; repeat<2; repeat++) {
                for (int i = 0; i < stepSize; i++) {
                    if (result.size()==n) return result;
                    x += DIRS[dir][0];
                    y += DIRS[dir][1];
                    result.add(new int[]{x,y});
                }
                dir = (dir+1)%4;
            }
            stepSize++;
        }
        return result;
    }




}

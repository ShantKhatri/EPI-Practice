package arrays;

import java.util.List;

public class Rotate2DArray {

    public static void rotateMatrix(List<List<Integer>> squareMatrix) {
        final int matrixSize = squareMatrix.size()-1;
        for (int i = 0; i < (squareMatrix.size() / 2); i++) {
            for (int j = 0; j < matrixSize - i; j++) {
                int temp1 = squareMatrix.get(i).get(j);
                int temp2 = squareMatrix.get(j).get(matrixSize - i);
                int temp3 = squareMatrix.get(matrixSize-i).get(matrixSize-j);
                int temp4 = squareMatrix.get(matrixSize-j).get(i);
                squareMatrix.get(i).set(matrixSize-j, temp1);
                squareMatrix.get(matrixSize-j).set(matrixSize-i, temp2);
                squareMatrix.get(matrixSize-i).set(j, temp3);
                squareMatrix.get(i).set(j, temp4);
            }
        }
    }
}

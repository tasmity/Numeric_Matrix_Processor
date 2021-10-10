package processor;

import java.util.*;
import java.util.stream.Collectors;

public class MatrixTranspose extends Matrix {
    private static Matrix matrix;
    static int code;

    public MatrixTranspose(int y, int x) {
        super(y, x);
    }

    static void printMatrixTranspose() {
        System.out.println("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice: ");
        code = scanner.nextInt();
        setMatrix(0);
    }


    static void setMatrix(int code) {
        System.out.println("Enter matrix size: ");
        matrix = new Matrix(scanner.nextInt(), scanner.nextInt());
        if (code != 0 && !MatrixDeterminant.checkMatrixTo(matrix)) {
            Matrices.sendError();
            return;
        }
        System.out.println("Enter matrix: ");
        matrix.pullMatrix();
        if (code == 5)
            MatrixDeterminant.matrixDeterminant(matrix);
        else if (code == 6)
            MatrixInverse.matrixInverse(matrix);
        else
            setFunction();
    }

    static void setFunction() {
        switch (code) {
            case 1:
                mainDiagonal();
                break;
            case 2:
                sideDiagonal();
                break;
            case 3:
                verticalLine(matrix);
                break;
            case 4:
                matrix = horizontalLine(matrix);
                break;
            default:
                break;
        }
        matrix.printMatrix();
    }

    static Matrix mainDiagonal() {
        var temp = new Matrix(matrix.getArray()[0].length, matrix.getArray().length);
        for (var y = 0; y < matrix.getArray().length; y++)
            for (var x = 0; x < matrix.getArray()[0].length; x++)
                temp.setArray(x, y, matrix.getArray(y, x));
        matrix = temp;
        return temp;
    }

    static void sideDiagonal() {
        for (var y = 0; y < (matrix.getArray()[0].length - 1); y++)
            for (var x = 0; x < (matrix.getArray()[0].length - 1) - y; x++) {
                double tmp = matrix.getArray(y, x);
                matrix.setArray(y, x, matrix.getArray(matrix.getArray()[0].length - 1 - x,
                        matrix.getArray()[0].length - 1 - y));
                matrix.setArray(matrix.getArray()[0].length - 1 - x, matrix.getArray()[0].length - 1 - y,
                        tmp);
            }
    }

    static void verticalLine(Matrix matrix) {
        for (var y = 0; y < matrix.getArray().length; y++) {
            List<Double> list = Arrays.stream(matrix.getArray(y)).boxed().collect(Collectors.toList());
            Collections.reverse(list);
            double[] tmp = list.stream().mapToDouble(l -> l).toArray();
            matrix.setArray(y, tmp);
        }
    }

    static Matrix horizontalLine(Matrix matrix) {
        var temp = new Matrix(matrix.getArray().length, matrix.getArray()[0].length);
        for (var y = 0; y < matrix.getArray().length; y++) {
            temp.setArray(y, matrix.getArray(matrix.getArray().length - 1 - y));
        }
        return temp;
    }
}

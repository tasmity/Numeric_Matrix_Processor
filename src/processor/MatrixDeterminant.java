package processor;

public class MatrixDeterminant extends Matrix {

    public MatrixDeterminant(int y, int x) {
        super(y, x);
    }

    static void setMatrixDeterminant(int code) {
        MatrixTranspose.setMatrix(code);
    }

    static void matrixDeterminant(Matrix matrix) {
        System.out.printf("The result is:%n %.2f%n%n", matrixDet(matrix.getArray()));
    }

    static boolean checkMatrixTo(Matrix matrix) {
        return matrix.getArray().length == matrix.getArray()[0].length;
    }

    static double matrixDet(double[][] matrix) {
        if (matrix.length == 1)
            return matrix[0][0];
        double det = 0;
        double cofactor;
        for (var i = 0; i < matrix.length; i++) {
            cofactor = Math.pow(-1, i) * matrixDet(tempMatrix(matrix, i)) * matrix[0][i];
            det += cofactor;
        }
        return det;
    }

    public static double[][] tempMatrix(double[][] matrix, int index) {
        double[][] temp = new double[matrix.length - 1][matrix.length - 1];
        for (var i = 1; i < matrix.length; i++) {
            for (var j = 0; j < matrix.length; j++) {
                if (j > index)
                    temp[i - 1][j - 1] = matrix[i][j];
                else if (j != index)
                    temp[i - 1][j] = matrix[i][j];
            }
        }
        return temp;
    }
}

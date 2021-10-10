package processor;

public class MultiplyMatrix extends Matrix {

    public MultiplyMatrix(int y, int x) {
        super(y, x);
    }

    static boolean checkMatrixTo(Matrix matrix1, Matrix matrix2) {
        return matrix1.getArray()[0].length == matrix2.getArray().length;
    }

    static void multiplyMatrices(Matrix matrix1, Matrix matrix2) {
        var matrix = new Matrix(matrix1.getArray().length, matrix2.getArray()[0].length);
        for (var y = 0; y < matrix.getArray().length; y++) {
            for (var x = 0; x < matrix.getArray()[0].length; x++) {
                for (var i = 0; i < matrix2.getArray().length; i++) {
                    matrix.setArray(y, x, matrix.getArray(y, x) +
                            (matrix1.getArray(y, i) * matrix2.getArray(i, x)));
                }
            }
        }
        matrix.printMatrix();
    }
}

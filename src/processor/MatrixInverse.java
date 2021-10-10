package processor;

public class MatrixInverse extends Matrix {
    public MatrixInverse(int y, int x) {
        super(y, x);
    }

    static void setMatrixInverse(int code) {
        MatrixTranspose.setMatrix(code);
    }

    static void matrixInverse(Matrix matrix) {
        double det = MatrixDeterminant.matrixDet(matrix.getArray());
        if (det == 0.0) {
            System.out.println("This matrix doesn't have an inverse.\n\n");
            return;
        }
        Matrix cofactor = setCofactor(MatrixTranspose.mainDiagonal());
        inverse(cofactor, det);
        cofactor.printMatrix();
    }

    static Matrix minor(Matrix matrix, int row, int column) {
        var temp = new Matrix(matrix.getArray().length - 1, matrix.getArray().length - 1);
        for (var y = 0; y < matrix.getArray().length; y++) {
            for (var x = 0; y != row && x < matrix.getArray()[y].length; x++) {
                if (x != column)
                    temp.setArray(y < row ? y : y - 1, x < column ? x : x - 1, matrix.getArray(y, x));
            }
        }
        return temp;
    }

    static Matrix setCofactor(Matrix matrix) {
        var temp = new Matrix(matrix.getArray().length, matrix.getArray()[0].length);
        for (var y = 0; y < matrix.getArray().length; y++)
            for (var x = 0; x < matrix.getArray()[y].length; x++) {
                temp.setArray(y, x, Math.pow(-1, y + x) *
                        MatrixDeterminant.matrixDet(minor(matrix, y, x).getArray()));
            }
        return temp;
    }

    static void inverse(Matrix matrix, double det) {
        MatrixMultiplyConstant.factorMatrix(matrix, 1 / det);
    }
}

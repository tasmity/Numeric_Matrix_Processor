package processor;

public class AddMatrices extends Matrix {

    public AddMatrices(int y, int x) {
        super(y, x);
    }

    static void printAddMatrix(int code) {
        System.out.println("Enter size of first matrix: ");
        var matrix1 = new Matrix(scanner.nextInt(), scanner.nextInt());
        System.out.println("Enter first matrix: ");
        matrix1.pullMatrix();
        System.out.println("Enter size of second matrix: ");
        var matrix2 = new Matrix(scanner.nextInt(), scanner.nextInt());
        System.out.println("Enter second matrix: ");
        matrix2.pullMatrix();
        if (!(code == 1 ? checkMatrixTo(matrix1, matrix2) : MultiplyMatrix.checkMatrixTo(matrix1, matrix2))) {
            Matrices.sendError();
            return;
        }
        if (code == 1)
            sumMatrix(matrix1, matrix2);
        else
            MultiplyMatrix.multiplyMatrices(matrix1, matrix2);
    }

    private static boolean checkMatrixTo(Matrix matrix1, Matrix matrix2) {
        return matrix1.getArray().length == matrix2.getArray().length &&
                matrix1.getArray()[0].length == matrix2.getArray()[0].length;
    }

    static void sumMatrix(Matrix matrix1, Matrix matrix2) {
        var matrix = new Matrix(matrix1.getArray().length, matrix1.getArray()[0].length);
        for (var y = 0; y < matrix.getArray().length; y++) {
            for (var x = 0; x < matrix.getArray()[y].length; x++)
                matrix.setArray(y, x,matrix1.getArray(y, x) + matrix2.getArray(y, x));
        }
        matrix.printMatrix();
    }
}

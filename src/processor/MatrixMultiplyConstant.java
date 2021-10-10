package processor;

public class MatrixMultiplyConstant extends Matrix {
    static double constant;

    public MatrixMultiplyConstant(int y, int x) {
        super(y, x);
    }


    static void printMultiConst() {
        System.out.println("Enter size of matrix: ");
        var matrix = new Matrix(scanner.nextInt(), scanner.nextInt());
        System.out.println("Enter matrix: ");
        matrix.pullMatrix();
        System.out.println("Enter constant: ");
        constant = scanner.nextDouble();
        factorMatrix(matrix, constant);
        matrix.printMatrix();
    }

    static void factorMatrix(Matrix matrix, double constant) {
        for (var y = 0; y < matrix.getArray().length; y++) {
            for (var x = 0; x < matrix.getArray()[y].length; x++)
                matrix.setArray(y, x , matrix.getArray(y, x) * constant);
        }
    }
}

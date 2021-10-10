package processor;

import java.util.Scanner;

public interface Matrices {
    Scanner scanner = new Scanner(System.in);

    static void printWelcome() {
        var code = -1;
        while (code != 0) {
            System.out.println("1. Add matrices\n" +
                    "2. Multiply matrix by a constant\n" +
                    "3. Multiply matrices\n" +
                    "4. Transpose matrix\n" +
                    "5. Calculate a determinant\n" +
                    "6. Inverse matrix\n" +
                    "0. Exit\n" +
                    "Your choice: ");
            code = scanner.nextInt();
            function(code);
        }
    }

    static void function(int code) {
        switch (code) {
            case 0:
                return;
            case 1: case 3:
                AddMatrices.printAddMatrix(code);
                break;
            case 2:
                MatrixMultiplyConstant.printMultiConst();
                break;
            case 4:
                MatrixTranspose.printMatrixTranspose();
                break;
            case 5:
                MatrixDeterminant.setMatrixDeterminant(code);
                break;
            case 6:
                MatrixInverse.setMatrixInverse(code);
                break;
            default:
                sendError();
        }
    }

    static void sendError() {
        System.out.println("The operation cannot be performed.\n");
    }
}

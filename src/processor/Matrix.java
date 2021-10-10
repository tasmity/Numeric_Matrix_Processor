package processor;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Matrix implements Matrices {
    private final double[][] array;

    public Matrix(int y, int x) {
        this.array = new double[y][x];
    }

    public double[][] getArray() {
        return array;
    }

    public double[] getArray(int y) {
        return this.array[y];
    }

    public double getArray(int y, int x) {
        return this.array[y][x];
    }

    public void setArray(int y, int x, double num) {
        this.array[y][x] = num;
    }

    public void setArray(int y, double[] array) {
        this.array[y] = array;
    }

    void pullMatrix() {
        for (var y = 0; y < this.array.length; y++) {
            for (var x = 0; x < this.array[y].length; x++)
                this.array[y][x] = scanner.nextDouble();
        }
    }

    void printMatrix() {
        System.out.println("The result is: ");
        for (double[] y : this.array)
            System.out.println(DoubleStream.of(y).mapToObj(Double::toString).
                    collect(Collectors.joining(" ")));
        System.out.println();
    }
}

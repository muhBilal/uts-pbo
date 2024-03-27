package org.example;

public class Matrix {
    private double[][] matrix;

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matriks harus berbentuk persegi untuk menghitung determinan");
        }

        int n = matrix.length; // ukuran matriks

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int j = 0; j < n; j++) {
            det += Math.pow(-1, j) * matrix[0][j] * determinant(minor(matrix, 0, j));
        }
        return det;
    }

    public static double[][] minor(double[][] matrix, int rowToRemove, int colToRemove) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];
        int minorRow = 0;
        int minorCol;
        for (int row = 0; row < matrix.length; row++) {
            if (row != rowToRemove) {
                minorCol = 0;
                for (int col = 0; col < matrix.length; col++) {
                    if (col != colToRemove) {
                        minor[minorRow][minorCol] = matrix[row][col];
                        minorCol++;
                    }
                }
                minorRow++;
            }
        }
        return minor;
    }

    public static double[][] penjumlahan(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matriks harus memiliki dimensi yang sama untuk penjumlahan");
        }

        double[][] hasil = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                hasil[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return hasil;
    }

    public static double[][] pengurangan(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matriks harus memiliki dimensi yang sama untuk pengurangan");
        }

        double[][] hasil = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                hasil[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return hasil;
    }

    public static double[][] perkalian(double[][] matrix1, double[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Jumlah kolom dalam matriks pertama harus sama dengan jumlah baris dalam matriks kedua untuk perkalian");
        }

        double[][] hasil = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    hasil[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return hasil;
    }

    public static void main(String[] args) {
        double[][] matrix1 = {
                {3, 0, -7},
                {-2, 1, -1},
                {4, 6, 5}
        };

        double[][] matrix2 = {
                {2, 0, -1},
                {1, 8, 0},
                {0, 2, 6}
        };

        Matrix matrixObj1 = new Matrix();
        Matrix matrixObj2 = new Matrix();

        matrixObj1.setMatrix(matrix1);
        matrixObj2.setMatrix(matrix2);

        System.out.println("Matriks 1:");
        displayMatrix(matrixObj1.getMatrix());

        System.out.println("\nMatriks 2:");
        displayMatrix(matrixObj2.getMatrix());

        // Operasi
        System.out.println("\nPenjumlahan:");
        displayMatrix(penjumlahan(matrix1, matrix2));

        System.out.println("\nPengurangan:");
        displayMatrix(pengurangan(matrix1, matrix2));

        System.out.println("\nPerkalian:");
        displayMatrix(perkalian(matrix1, matrix2));

        System.out.println("\nDeterminan Matriks 1: " + determinant(matrix1));
        System.out.println("\nDeterminan Matriks 2: " + determinant(matrix2));
    }
}

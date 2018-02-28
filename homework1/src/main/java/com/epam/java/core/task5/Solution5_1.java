package com.epam.java.core.task5;

public class Solution5_1 {
    public int[][] getCrossMatrix(int size) {
        int [][] array = new int [size][size];
        for (int i = 0; i < size; i++ ) {
            for (int j = 0; j < size; j++) {
                if((i == j)||((i + j)) == (size - 1)) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++ ) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Solution5_1 solution5_1 = new Solution5_1();
        printMatrix(solution5_1.getCrossMatrix(50));
    }
}

package com.epam.tat.matrixprocessor.impl;

import java.util.Arrays;

public class TestTurn {
    public static void main(String[] args) {
        MatrixProcessor matrixProcessor = new MatrixProcessor();
        double[][] matrix = {{1, 2},
                             {3, 4},
                             {5, 6}};
        double[][] clockwise = matrixProcessor.transpose(matrix);
        System.out.println(Arrays.deepToString(clockwise));
    }
}

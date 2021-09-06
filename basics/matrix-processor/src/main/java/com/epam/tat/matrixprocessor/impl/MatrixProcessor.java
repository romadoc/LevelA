package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import java.math.BigDecimal;

/**
 * Function Description:
 * Complete the functions below. All methods must work with matrices of the double type.
 *
 * Constraints:
 * 0 < m < 10
 * 0 < n < 10
 * where m - number of rows in matrix
 * where n - number of columns in matrix
 *
 * In case of incorrect input values or inability to perform a calculation, the method should throw an appropriate
 * exception.
 *
 */
public class MatrixProcessor implements IMatrixProcessor {

	/**
	 * Matrix transpose is an operation on a matrix where its rows become columns with the same numbers.
	 * Ex.:
	 * |1 2|			|1 3 5|
	 * |3 4|   ====>	|2 4 6|
	 * |5 6|
	 *
	 * @param matrix - matrix for transposition
	 * @return the transposed matrix
	 */
	@Override
	public double[][] transpose(double[][] matrix) {
        if (isArrayIsNull(matrix) || isArrayEmpty(matrix)) {
            throw new MatrixProcessorException();
        }
	    int n = matrix.length;
        double[][] transposedMatrix = new double[matrix[0].length][matrix.length];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        transposedMatrix[j][i] = matrix[i][j];
                    }
                }

        return transposedMatrix;

	}

	/**
	 * The method flips the matrix clockwise.
	 * Ex.:
	 * * |1 2|			|5 3 1|
	 * * |3 4|   ====>	|6 4 2|
	 * * |5 6|
	 *
	 * @param matrix - rotation matrix
	 * @return rotated matrix
	 */
	@Override
	public double[][] turnClockwise(double[][] matrix) {
        if (isArrayIsNull(matrix) || isArrayEmpty(matrix)) {
            throw new MatrixProcessorException();
        }
        double[][] turnedMatrix = new double[matrix[0].length][matrix.length];
	    int n = matrix.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < matrix[i].length; j++)
                turnedMatrix[j] [n - i - 1] = matrix[i][j];
        return turnedMatrix;

	}

	/**
	 * This method multiplies matrix firstMatrix by matrix secondMatrix
	 *
	 * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
	 *
	 * @param firstMatrix  - first matrix to multiply
	 * @param secondMatrix - second matrix to multiply
	 * @return result matrix
	 */
	@Override
	public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        if (isArrayIsNull(firstMatrix) || isArrayEmpty(firstMatrix) || isArrayIsNull(secondMatrix)
                                                                    || isArrayEmpty(secondMatrix)) {
            throw new MatrixProcessorException();
        }
        double[][]thirdMatrix = new double [firstMatrix.length][secondMatrix[0].length];
        for (int i = 0; i < thirdMatrix[0].length; i++)
            for (int j = 0; j < secondMatrix.length; j++)
                for (int k = 0; k < firstMatrix[0].length; k++)
                    thirdMatrix[i][j] = roundDouble(thirdMatrix[i][j] + firstMatrix[i][k] * secondMatrix[k][j]);

		return thirdMatrix;
	}

	/**
	 * This method returns the inverse of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Invertible_matrix}
	 *
	 * @param matrix - input matrix
	 * @return inverse matrix for input matrix
	 */
	@Override
	public double[][] getInverseMatrix(double[][] matrix) {
        if (isArrayIsNull(matrix) || isArrayEmpty(matrix)) {
            throw new MatrixProcessorException();
        }
        RealMatrix matrix1 = new Array2DRowRealMatrix(matrix, false);
        if (!matrix1.isSquare()) {
            throw new MatrixProcessorException();
        }
        RealMatrix realMatrix = MatrixUtils.inverse(matrix1);

        int m = realMatrix.getRowDimension();
        int n = realMatrix.getColumnDimension();
        double[][] inversedMatrix = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                inversedMatrix[i][j] = roundDouble(realMatrix.getEntry(i, j));

            }
        }

        return inversedMatrix;

	}

	/**
	 * This method returns the determinant of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Determinant}
	 *
	 * @param matrix - input matrix
	 * @return determinant of input matrix
	 */
	@Override
	public double getMatrixDeterminant(double[][] matrix) {
        if (isArrayIsNull(matrix) || isArrayEmpty(matrix)) {
            throw new MatrixProcessorException();
        }

        RealMatrix realMatrix = MatrixUtils.createRealMatrix(matrix);

        if (!realMatrix.isSquare()) {
            throw new MatrixProcessorException();
        }

        return roundDouble(new LUDecomposition(realMatrix).getDeterminant());
	}

	private double roundDouble(double c) {
        BigDecimal result = new BigDecimal(c);
        result = result.setScale(3, BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }

    private boolean isArrayEmpty(double[][] matrix) {
	    return ArrayUtils.isEmpty(matrix);
    }
    private boolean isArrayIsNull(double[][] matrix) {
	    return matrix == null;
    }

}

package com.vrrs.alg.problems.dynamicprog;

public class Matrix {

	public int getLargestSquareOf1(int[][] m) {
		int rowSize = m.length;
		int colSize = m[0].length;
		int[][] length = new int[rowSize][colSize];
		for (int i = 0; i < rowSize; i++) length[i][0] = m[i][0];
		for (int j = 0; j < colSize; j++) length[0][j] = m[0][j];
		int largestSquare = 0;
		for (int row = 1; row < rowSize; row++) {
			for (int col = 1; col < colSize; col++) {
				if (m[row][col] == 1) {
					int min = Math.min(length[row - 1][col], length[row][col - 1]);
					min = Math.min(min, length[row - 1][col - 1]);
					length[row][col] = min + 1;
					if (length[row][col] > largestSquare)
						largestSquare = length[row][col];
				} else {
					length[row][col] = 0;
				}
			}
		}
		return largestSquare;
	}

}

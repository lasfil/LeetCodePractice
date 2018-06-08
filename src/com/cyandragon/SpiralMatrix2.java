package com.cyandragon;
/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/
public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];

		if (n == 0)
			return result;

		int a = 0;
		int k = 1;

		while (a <= (n - 1) / 2) {
			for (int j = a; j < n - a; j++) {
				result[a][j] = k++;
			}
			for (int i = a + 1; i < n - a; i++) {
				result[i][n - 1 - a] = k++;
			}

			if (a != n - 1 - a) {
				for (int j = n - 2 - a; j >= a; j--) {
					result[n - 1 - a][j] = k++;
				}
				for (int i = n - 2 - a; i > a; i--) {
					result[i][a] = k++;
				}
			}
			a++;
		}

		return result;
	}
}

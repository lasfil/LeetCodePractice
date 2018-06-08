package com.cyandragon;
import java.util.ArrayList;
import java.util.List;
/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ 
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        List<Integer> result = new ArrayList<Integer>();
        if (m == 0)
            return result;
        int n = matrix[0].length;
        int a = 0;
        int half = Math.min((m - 1), (n - 1)) / 2;

		while (a <= half) {
			for (int j = a; j < n - a; j++)
				result.add(matrix[a][j]);

			for (int i = a + 1; i < m - a; i++)
				result.add(matrix[i][n - 1 - a]);

			if (a != m - 1 - a) {
				for (int j = n - 2 - a; j >= a; j--)
					result.add(matrix[m - 1 - a][j]);
			}
			if (a != n - 1 - a){
				for (int i = m - 2 - a; i > a; i--)
					result.add(matrix[i][a]);
			}
			a++;
		}

        return result;
    }
}

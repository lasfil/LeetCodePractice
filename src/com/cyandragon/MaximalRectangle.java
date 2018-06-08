package com.cyandragon;
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null)
			return 0;
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		if (m * n == 1)
			return matrix[0][0] - '0';

		Longest[][] dis = new Longest[m][n];
		int hor = 0;
		int ver = 0;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (i > 0 && matrix[i - 1][j] == '1')
						ver = dis[i - 1][j].ver + 1;
					else
						ver = 1;
					if (j > 0 && matrix[i][j - 1] == '1')
						hor = dis[i][j - 1].hor + 1;
					else
						hor = 1;
					dis[i][j] = new Longest(hor, ver);
					max = Math.max(ver * hor, max);
				}

			}
		}

		return max;
	}
	
	public int maximalRectangle1(char[][] matrix) {
		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int maxArea = 0;
		int cols = matrix[0].length;
		int[][] map = new int[rows][cols];
		for (int j = 0; j < cols; j++) {
			map[0][j] = matrix[0][j] == '0' ? 0 : 1;
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				map[i][j] = matrix[i][j] == '0' ? map[i - 1][j]
						: map[i - 1][j] + 1;
			}
		}
		int c = 0;
		int[] row = new int[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < rows; j++) {
				for (int k = 0; k < cols; k++) {
					row[k] = map[j][k] - (i == 0 ? 0 : map[i - 1][k]);
				}
				int count = 0;
				for (int k = 0; k < cols; k++) {
					if (row[k] == j - i + 1) {
						maxArea = Math.max(maxArea, ++count * (j - i + 1));
					} else {
						maxArea = Math.max(maxArea, count * (j - i + 1));
						count = 0;
					}
				}
			}
		}
		return maxArea;
	}

	private class Longest {
		int hor;
		int ver;

		Longest(int hor, int ver) {
			this.hor = hor;
			this.ver = ver;
		}
	}

	public static void main(String[] args) {
		String[] str = new String[] { "01101", "11010", "01110", "11110",
				"11111", "00000" };
		char[][] matrix = new char[][] { str[0].toCharArray(),
				str[1].toCharArray(), str[2].toCharArray(),
				str[3].toCharArray(), str[4].toCharArray(), str[5].toCharArray()};
		System.out.println(new MaximalRectangle().maximalRectangle1(matrix));
	}

}

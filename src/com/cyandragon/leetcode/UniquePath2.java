package com.cyandragon.leetcode;
public class UniquePath2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] maps = new int[m][n];
		boolean firstrowobs = false;
		for (int i = m - 1; i >= 0; i--) {
			if (obstacleGrid[i][n - 1] == 1)
				firstrowobs = true;
			maps[i][n - 1] = firstrowobs ? 0 : 1;
		}
		firstrowobs = false;
		for (int i = n - 1; i >= 0; i--) {
			if (obstacleGrid[m - 1][i] == 1)
				firstrowobs = true;
			maps[m - 1][i] = firstrowobs ? 0 : 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				int right = obstacleGrid[i][j + 1] == 1 ? 0
						: maps[i][j + 1] ;
				int down = obstacleGrid[i + 1][j] == 1 ? 0
						: maps[i + 1][j];
				maps[i][j] = obstacleGrid[i][j] == 1 ? 0 : right + down;
			}
		}

		return maps[0][0];
	}
	
	public static void main(String[] args) {
		int[][] obs = new int[][]{{0, 0}, {0, 0}};
		System.out.println(new UniquePath2().uniquePathsWithObstacles(obs));
	}
}

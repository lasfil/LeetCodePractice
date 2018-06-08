package com.cyandragon.leetcode;
/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;

		int[][] path = new int[m][n];
		path[m - 1][n - 1] = grid[m - 1][n - 1];
		for (int i = n - 2; i >= 0; i--) {
			path[m - 1][i] = path[m - 1][i + 1] + grid[m - 1][i];
		}

		for (int i = m - 2; i >= 0; i--) {
			path[i][n - 1] = path[i + 1][n - 1] + grid[i][n - 1];
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				path[i][j] = grid[i][j]
						+ Math.min(path[i + 1][j], path[i][j + 1]);
			}
		}

		return path[0][0];
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 2 }, { 1, 1 } };
		System.out.println(new MinimumPathSum().minPathSum(grid));
	}
}

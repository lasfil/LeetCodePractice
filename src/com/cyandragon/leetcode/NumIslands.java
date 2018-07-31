package com.cyandragon.leetcode;

import org.junit.Test;

public class NumIslands {
	@Test
	public void test() {
		numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } });
	}

	public static int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] nums = new int[m + 2][n + 2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				nums[i + 1][j + 1] = grid[i][j] == '0' ? 0 : 1;
			}
		}
		int count = 1;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (nums[i][j] == 1) {
					if (nums[i - 1][j] > nums[i][j]) {
						nums[i][j] = nums[i - 1][j];
					} else if (nums[i][j - 1] > nums[i][j]) {
						nums[i][j] = nums[i][j - 1];
					} else if (nums[i + 1][j] > nums[i][j]) {
						nums[i][j] = nums[i + 1][j];
					} else if (nums[i][j + 1] > nums[i][j]) {
						nums[i][j] = nums[i][j + 1];
					} else {
						nums[i][j] = nums[i][j] + count++;
					}
				}
			}
		}

		return count - 1;
	}
}

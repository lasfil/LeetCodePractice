package com.cyandragon.leetcode;

public class BeautifulArrangement {
	public static void countArrangement() {
		System.out.println(countArrangement(5));
	}

	private static int count;

	public static int countArrangement(int N) {

		if (N < 4) {
			return N;
		}
		int[][] possible = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			int right = 1;
			for (int j = 1; j <= N; j++) {
				if (i % j == 0 || j % i == 0) {
					possible[i][right++] = j;
				}
			}
		}

		countArrangement(possible, 1);

		return count;
	}

	public static void countArrangement(int[][] possible, int row) {
		if (row == possible.length) {
			count++;
			return;
		}

		for (int col = 1; col < possible.length && possible[row][col] > 0; col++) {
			if (possible[possible[row][col]][0] == 0) {
				possible[possible[row][col]][0] = 1;
				countArrangement(possible, row + 1);
				possible[possible[row][col]][0] = 0;
			}
		}

	}
}

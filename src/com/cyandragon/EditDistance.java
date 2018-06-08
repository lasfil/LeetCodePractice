package com.cyandragon;
public class EditDistance {
	// 两种方法，一种用了m ＋ 1 ＊ n ＋ 1的额外空间，另一种只用一个一维数组维护DP
	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return Integer.MAX_VALUE;
		}

		int m = word1.length();
		int n = word2.length();
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}

		int[][] step = new int[n + 1][m + 1];
		for (int j = 0; j <= m; j++) {
			step[0][j] = j;
		}

		for (int i = 0; i <= n; i++) {
			step[i][0] = i;
		}

		for (int i = 1; i <= n; i++) {
			char c2 = word2.charAt(i - 1);
			for (int j = 1; j <= m; j++) {
				char c1 = word1.charAt(j - 1);
				if (c1 == c2) {
					step[i][j] = Math.min(step[i - 1][j - 1],
							Math.min(step[i][j - 1] + 1, step[i - 1][j] + 1));
				} else {
					step[i][j] = Math.min(step[i - 1][j - 1] + 1,
							Math.min(step[i][j - 1] + 1, step[i - 1][j] + 1));
				}
			}
		}
		System.out.println(step);
		return step[n][m];
	}

	public int minDistance1(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return Integer.MAX_VALUE;
		}

		int m = word1.length();
		int n = word2.length();
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}
		// 保证word1是短的，这样step长度比较短
		if (n < m) {
			return minDistance1(word2, word1);
		}

		int[] step = new int[m];
		// 初始化step值是1-m
		for (int j = 0; j < m; j++) {
			step[j] = j + 1;
		}

		for (int i = 0; i < n; i++) {
			char c2 = word2.charAt(i);

			char c1 = word1.charAt(0);
			// 每次改变step[i]之前先用cur纪录下来
			int cur = step[0];
			// 对于第一列pre就是i的值
			int pre = i;
			if (c1 == c2) {
				step[0] = pre;
			} else {
				step[0] = Math.min(pre + 1, step[0] + 1);
			}
			pre = cur;
			for (int j = 1; j < m; j++) {
				c1 = word1.charAt(j);
				cur = step[j];
				if (c1 == c2) {
					// c1等于c2时，step[i][j] = step[i-1][j-1]就是pre
					step[j] = pre;
				} else {
					step[j] = Math.min(pre + 1,
							Math.min(step[j - 1] + 1, step[j] + 1));
				}
				pre = cur;
			}
		}

		return step[m - 1];
	}

	public static void main(String[] args) {
		System.out.println(new EditDistance().minDistance("sea", "ate"));
		System.out.println(new EditDistance().minDistance1("sea", "ate"));
		System.out.println(new EditDistance().minDistance("ab", "bc"));
		System.out.println(new EditDistance().minDistance1("ab", "bc"));

		System.out.println(new EditDistance().minDistance("mart", "karma"));
		System.out.println(new EditDistance().minDistance1("martaaaaaa",
				"karma"));
	}
}

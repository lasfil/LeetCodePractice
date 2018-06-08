package com.cyandragon.dynamicprogramming;

/*Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

*/
public class IntegerBreak {
	public static void integerBreak() {
		System.out.println(integerBreak1(17));
	}

	public static int integerBreak(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}

		int half = n / 2;
		return (half < 5 ? half : integerBreak(half)) * ((n - half) < 5 ? (n - half) : integerBreak(n - half));
	}

	/*
	 * 解法一（纯dp）：
	 * 
	 * 令dp[n]为n对应的最大积。
	 * 
	 * 那么递推方程就是：dp[n]=max(i*dp[n-i],i*(n-i))(其中i从1到n-1)。
	 * 
	 * 边界:dp[2]=1;
	 * 
	 * 时间复杂度：O(n2)
	 */
	public static int integerBreak1(int n) {
		// 1.Init except dp[n], since it cannot be itself and must break into two
		// positive
		int[] maxProd = new int[n + 1];
		for (int i = 1; i < n; i++) {
			maxProd[i] = i;
		}

		// 2.Compute max product
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i - j; j++) { // Note: only check j <= i - j
				maxProd[i] = Math.max(maxProd[i], maxProd[j] * maxProd[i - j]);
			}
		}
		return maxProd[n];
	}
}

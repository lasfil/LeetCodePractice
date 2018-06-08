package com.hungerfool;

import com.cyandragon.leetcode.Playboard;

public class PredictTheWinner {
	private static int sum1 = 0;
	private static int sum2 = 0;

	public static void predictTheWinner() {
		System.out.println(
				PredictTheWinner1(new int[] { 2, 5, 4, 324, 534, 4323, 33, 33, 2, 45, 44, 77, 57, 4, 56, 4, 78 }));
	}

	// Solution 1: Using Recursion
	// Time complexity: O(2^n). Size of recursion tree will be 2^n. Here, n refers
	// to the length of nums array.
	// Space complexity: O(n). The depth of the recursion tree can go upto n.
	public static boolean PredictTheWinner1(int[] nums) {
		return winner(nums, 0, nums.length - 1, 1) >= 0;
	}

	public static int winner(int[] nums, int s, int e, int turn) {
		if (s == e)
			return turn * nums[s];
		int a = turn * nums[s] + winner(nums, s + 1, e, -turn);
		int b = turn * nums[e] + winner(nums, s, e - 1, -turn);
		return turn * Math.max(turn * a, turn * b);
	}

	// Solution 2: Similar Approach
	// Time complexity: O(n^2). The entire memomemo array of size nnxnn is filled
	// only once. Here, n refers to the size of nums array.
	// Space complexity: O(n^2). memo array of size nxn is used for memoization.
	public boolean PredictTheWinner2(int[] nums) {
		Integer[][] memo = new Integer[nums.length][nums.length];
		return winner(nums, 0, nums.length - 1, memo) >= 0;
	}

	public int winner(int[] nums, int s, int e, Integer[][] memo) {
		if (s == e)
			return nums[s];
		if (memo[s][e] != null)
			return memo[s][e];
		int a = nums[s] - winner(nums, s + 1, e, memo);
		int b = nums[e] - winner(nums, s, e - 1, memo);
		memo[s][e] = Math.max(a, b);
		return memo[s][e];
	}

	// Solution 3: Dynamic Programming
	// Time complexity : O(n^2). ((n+1)xn)/2 entries in dp array of size (n+1)xn is
	// filled once. Here, n refers to the length of nums array.
	// Space complexity : O(n^2). dp array of size (n+1)xn is used.
	public boolean PredictTheWinner3(int[] nums) {
		int[][] dp = new int[nums.length + 1][nums.length];
		for (int s = nums.length; s >= 0; s--) {
			for (int e = s + 1; e < nums.length; e++) {
				int a = nums[s] - dp[s + 1][e];
				int b = nums[e] - dp[s][e - 1];
				dp[s][e] = Math.max(a, b);
			}
		}
		return dp[0][nums.length - 1] >= 0;
	}

	// Solution 4: 1D Dynamic Programming
	// Time complexity : O(n^2). The elements of dpdp array are updated 1+2+3+...+n
	// times. Here, n refers to the length of nums array.
	// Space complexity : O(n). 1-D dpdp array of size n is used.
	public boolean PredictTheWinner(int[] nums) {
		int[] dp = new int[nums.length];
		for (int s = nums.length; s >= 0; s--) {
			for (int e = s + 1; e < nums.length; e++) {
				int a = nums[s] - dp[e];
				int b = nums[e] - dp[e - 1];
				dp[e] = Math.max(a, b);
			}
		}
		return dp[nums.length - 1] >= 0;
	}

	private static void predictTheWinner(int[] nums, int left, int right) {
		if (left - right == 1) {
			return;
		}

		if (left == right) {
			sum1 += nums[left];
			return;
		}

		sum1 += nums[left];

		predictTheWinner(nums, left + 1, right);

		sum2 -= nums[right];
		sum2 += nums[left + 1];
		predictTheWinner(nums, left + 2, right);

		sum1 -= nums[left];
		sum2 -= nums[left + 1];

		sum1 += nums[right];
		sum2 += nums[left];
		predictTheWinner(nums, left + 1, right - 1);

		sum2 -= nums[left];
		sum2 += nums[right - 1];
		predictTheWinner(nums, left, right - 2);

	}
}

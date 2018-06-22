package com.cyandragon.leetcode;

public class MinSubArrayLen {
	public static void main(String[] args) {
		minSubArrayLen(0, new int[] { 1 });
	}

	public static int minSubArrayLen(int s, int[] nums) {
		if (nums == null) {
			return 0;
		}

		int l = 0;
		int r = 0;
		int sum = 0;
		int min = nums.length + 1;
		while (r < nums.length) {
			sum += nums[r++];

			while (sum >= s) {
				min = Math.min(min, r - l);
				sum -= nums[l++];
			}
		}
		if (min == nums.length + 1) {
			return 0;
		}
		return min;
	}
}

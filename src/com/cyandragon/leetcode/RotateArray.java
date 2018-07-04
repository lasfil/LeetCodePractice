package com.cyandragon.leetcode;

import org.junit.Test;

public class RotateArray {
	@Test
	public void test() {
		new RotateArray().rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
	}

	public void rotate(int[] nums, int k) {

		if (nums == null || k == 0) {
			return;
		}
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, k, nums.length - 1);
		reverse(nums, 0, k);
		return;

	}

	private void reverse(int[] nums, int s, int e) {
		while (s < e) {
			int temp = nums[s];
			nums[s] = nums[e];
			nums[e] = temp;
			s++;
			e--;
		}
	}

}

package com.cyandragon.leetcode;

public class FindUnsortedSubarray {
	public static void main(String[] args) {
		findUnsortedSubarray(new int[] { 1, 2, 3, 4 });
	}

	public static int findUnsortedSubarray(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int max = 0;
		int min = nums.length - 1;
		boolean turn = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				turn = true;
				if (nums[max] <= nums[i]) {
					max = i;
				}
				if (nums[min] > nums[i + 1]) {
					min = i + 1;
				}
			}
		}
		if (!turn) {
			return 0;
		}
		int l = 0;
		while (nums[l] <= nums[min]) {
			l++;
		}
		int r = nums.length - 1;
		while (nums[r] >= nums[max]) {
			r--;
		}
		if (r <= l) {
			return 0;
		}
		return r - l + 1;
	}
}

package com.cyandragon.leetcode;

import org.junit.Test;

public class ThirdMax {
	@Test
	public void test() {
		System.out.println(thirdMax(new int[] { 1, 2, 2, 5, 3, 5 }));
	}

	public static int thirdMax(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int f = Math.max(nums[0], nums[1]);
		int s = Math.min(nums[0], nums[1]);
		int t = nums[2];
		if (nums[2] > f) {
			t = s;
			s = f;
			f = nums[2];
		} else if (nums[2] > s) {
			t = s;
			s = nums[2];
		}

		for (int i = 3; i < nums.length; i++) {
			if (nums[i] > t) {
				if (nums[i] > f) {
					t = s;
					s = f;
					f = nums[i];
				} else if (nums[i] != f && nums[i] > s) {
					t = s;
					s = nums[i];
				} else if (nums[i] != s && nums[i] > t) {
					t = nums[i];
				}
			} else {
				if (t == s) {
					t = nums[i];
				}
			}
		}

		if (f == s)
			return f;
		if (s == t)
			return f;
		return t;
	}
}

package com.cyandragon.leetcode;

import org.junit.Test;

public class LargestNumber {
	@Test
	public void test() {
		System.out.println("lasfil".compareTo("liuhong"));
		new LargestNumber().largestNumber(new int[] { 2, 1 });
	}

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}

		quickSort(nums, 0, nums.length - 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}
		return sb.toString();
	}

	private void quickSort(int[] nums, int s, int e) {
		if (e <= s) {
			return;
		}
		if (e - s == 1) {
			if (compareTo(nums[s], nums[e]) < 0) {
				int temp = nums[e];
				nums[e] = nums[s];
				nums[s] = temp;
			}
			return;
		}
		int pivot = s;
		int l = s + 1;
		int r = e;
		while (l <= r) {
			if (compareTo(nums[l], nums[pivot]) > 0) {
				l++;
			} else if (compareTo(nums[r], nums[pivot]) < 0) {
				r--;
			} else {
				int temp = nums[l];
				nums[l] = nums[r];
				nums[r] = temp;
				l++;
				r--;
			}
		}
		int temp = nums[pivot];
		nums[pivot] = nums[r];
		nums[r] = temp;
		quickSort(nums, s, r - 1);
		quickSort(nums, r + 1, e);
	}

	private int compareTo(int a, int b) {
		return Long.valueOf(a + "" + b).compareTo(Long.valueOf(b + "" + a));
	}
}

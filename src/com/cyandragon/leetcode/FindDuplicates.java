package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[1,2,3,4,0,0,7,8]

Output:
[2,3]*/
public class FindDuplicates {
	public static List<Integer> findDuplicates() {
		int[] input = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		return findDuplicates(input);
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();

		int i = 0;
		while (i < nums.length) {
			if (nums[i] - 1 == i || nums[i] == 0) {
				i++;
			} else if (nums[i] == nums[nums[i] - 1]) {
				result.add(nums[i]);
				nums[i] = 0;
				i++;
			} else {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		return result;
	}

	public static List<Integer> findDuplicates1(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				result.add(Math.abs(nums[i]));
			} else {
				nums[index] = 0 - nums[index];
			}
		}

		return result;
	}
}

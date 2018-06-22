package com.cyandragon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindPairs {
	public static void main(String[] args) {
		findPairs(new int[] { 3, 1, 4, 1, 5 }, 2);

	}

	public static int findPairs(int[] nums, int k) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Map<Integer, Integer> unique = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			unique.put(nums[i], unique.getOrDefault(nums[i], 0) + 1);
		}
		int count = 0;
		if (k == 0) {
			for (Integer i : unique.values()) {
				count += i / 2;
			}
		} else {
			for (Integer i : unique.keySet()) {
				if (unique.get(Math.abs(k - i)) != null) {
					count++;
				}
			}
		}
		return count;
	}
}

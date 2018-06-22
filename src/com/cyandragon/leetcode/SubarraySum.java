package com.cyandragon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 0, 0, -1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 2 }, 0));
	}

	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		Map<Integer, Integer> sumcount = new HashMap<Integer, Integer>();
		sumcount.put(0, 1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sumcount.containsKey(sum - k)) {
				count += sumcount.get(sum - k);
			}
			sumcount.put(sum, sumcount.getOrDefault(sum, 0) + 1);
		}
		return count;

	}
}

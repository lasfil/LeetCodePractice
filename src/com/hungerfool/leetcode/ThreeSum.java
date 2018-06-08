package com.hungerfool.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ThreeSum {
	@Test
	public void test() {
		new ThreeSum().threeSum(new int[] { 0, 0, 0, 0 });
	}

	Set<Integer> used = new HashSet<Integer>();

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList();
		if (nums == null || nums.length < 3) {
			return result;
		}

		List<List<Integer>> twoSumList = null;
		for (int i = 0; i < nums.length - 2; i++) {
			if (!used.contains(nums[i])) {
				twoSumList = twoSum(nums, i);
				if (twoSumList.size() > 0) {
					result.addAll(twoSumList);
				}
			}
		}
		return result;
	}

	private List<List<Integer>> twoSum(int[] nums, int start) {
		Set<Integer> dic = new HashSet<Integer>();
		List<List<Integer>> result = new ArrayList();
		for (int i = start + 1; i < nums.length; i++) {
			if (!dic.contains(0 - nums[start] - nums[i])) {
				dic.add(nums[i]);
			} else {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(nums[start]);
				temp.add(0 - nums[start] - nums[i]);
				temp.add(nums[i]);
				result.add(temp);
				used.addAll(temp);
			}
		}

		return result;
	}
}

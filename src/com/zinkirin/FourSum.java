package com.zinkirin;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target?
 * 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <=
 * b <= c <= d) The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length < 4)
			return result;
		threeSum(num, target, 0, result);

		for (int i = 1; i < num.length - 3; i++) {
			if (num[i] != num[i - 1])
				threeSum(num, target, i, result);
		}

		return result;
	}

	private void threeSum(int[] num, int target, int index,
			List<List<Integer>> result) {
		twoSum(num, target, index + 1, result, index);
		for (int i = index + 2; i < num.length - 2; i++) {
			if (num[i] != num[i - 1])
				twoSum(num, target, i, result, index);
		}
	}

	private void twoSum(int[] num, int target, int index,
			List<List<Integer>> result, int lastIndex) {
		int i = index + 1;
		int j = num.length - 1;

		while (i < j) {
			int sum = num[i] + num[j] + num[index] + num[lastIndex];
			if (sum == target) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(num[lastIndex]);
				tmp.add(num[index]);
				tmp.add(num[i]);
				tmp.add(num[j]);

				result.add(tmp);
				// i继续向后移动直到下一个不重复的元素
				int k = i + 1;
				while (k < j && num[k] == num[i])
					k++;
				i = k;
				// j继续向前移动直到前一个不重复的元素
				k = j - 1;
				while (k > i && num[k] == num[j])
					k--;
				j = k;
			} else if (sum < target) {
				int k = i + 1;
				while (k < j && num[k] == num[i])
					k++;
				i = k;
			} else if (sum > target) {
				int k = j - 1;
				while (k > i && num[k] == num[j])
					k--;
				j = k;
			}

		}
	}
}

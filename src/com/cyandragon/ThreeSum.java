package com.cyandragon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ?
 * c) The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || num[i] != num[i - 1])
				twoSum(num, i, result);
		}
		return result;
	}

	private void twoSum(int[] num, int index, List<List<Integer>> result) {
		int i = index + 1;
		int j = num.length - 1;

		while (i < j) {
			int small = num[i];
			int big = num[j];
			int target = num[index];
			if (small + big == -target) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(target);
				tmp.add(small);
				tmp.add(big);

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
			} else if (small + big < -target) {
				int k = i + 1;
				while (k < j && num[k] == num[i])
					k++;
				i = k;
			} else if (small + big > -target) {
				int k = j - 1;
				while (k > i && num[k] == num[j])
					k--;
				j = k;
			}

		}
	}
}

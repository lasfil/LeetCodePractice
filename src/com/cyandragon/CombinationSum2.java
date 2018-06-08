package com.zinkirin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * 
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain duplicate
 * combinations. For example, given candidate set 10,1,2,7,6,1,5 and target 8, A
 * solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 */
public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		if (num == null)
			return null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		if (num.length == 0 || num[0] > target) {

			return result;
		}

		dfs(num, 0, target, result, new ArrayList<Integer>());

		return result;
	}

	public void dfs(int[] num, int start, int target,
			List<List<Integer>> result, ArrayList<Integer> current) {
		if (start >= num.length)
			return;

		int last = -1;
		for (int i = start; i < num.length; i++) {
			// 因为已经排好序，大于target之后的元素都不用考虑
			if (num[i] > target)
				break;
			// 重复元素也不用重复判断
			if (num[i] == last)
				continue;
			last = num[i];
			ArrayList<Integer> list = new ArrayList<Integer>(current);
			list.add(num[i]);
			if (num[i] == target) {
				result.add(list);
				return;
			} else
				dfs(num, i + 1, target - num[i], result, list);
		}
	}
}

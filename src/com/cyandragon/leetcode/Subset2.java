package com.cyandragon.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note: 
 * 
 * Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,2], a solution
 * is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class Subset2 {

	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		int len = num.length;
		if (len == 0)
			return result;
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(num[0]);
		result.add(first);
		if (len == 1) {
			return result;
		}

		List<List<Integer>> sub = subsetsWithDup(Arrays
				.copyOfRange(num, 1, len));

		for (List<Integer> list : sub) {
			if (list != null) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(num[0]);
				temp.addAll(list);
				if (!result.contains(temp))
					result.add(temp);
			}
            if (!result.contains(list))
				result.add(list);
			
		}

		return result;

	}

	public static void main(String[] args) {
		int[] num = new int[] { 1, 2 };

		System.out.println(new Subset2().subsetsWithDup(num));
	}
}

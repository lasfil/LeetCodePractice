package com.zinkirin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		int len = num.length;
		if (len == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}

		if (len == 1) {
			result.add(new ArrayList<Integer>());
			ArrayList<Integer> first = new ArrayList<Integer>();
			first.add(num[0]);
			result.add(first);
			return result;
		}

		List<List<Integer>> sub = subsets(Arrays.copyOfRange(num, 1, len));

		for (List<Integer> list : sub) {
			result.add(list);
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(num[0]);
			temp.addAll(list);
			result.add(temp);
		}

		return result;

	}

	public ArrayList<ArrayList<Integer>> subsets1(int[] S) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		subsets.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			int size = subsets.size();
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> subset = new ArrayList<Integer>(
						subsets.get(j));
				subset.add(S[i]);
				subsets.add(subset);
			}
		}
		return subsets;
	}

	public static void main(String[] args) {
		int[] s = new int[] { 2, 4, 6, 7, 9 };
		new Subsets().subsets(s);
	}
}

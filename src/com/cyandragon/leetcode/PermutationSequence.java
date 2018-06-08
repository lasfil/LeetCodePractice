package com.cyandragon.leetcode;
import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		if (n == 1)
			return "1";
		int mul = 1;
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for (int i = 1; i < n; i++) {
			mul *= i;
			list.add(i, i);
		}

		list.add(n);

		StringBuffer sb = new StringBuffer();
		if (k > mul * n)
			k = mul * n;
		permutation(sb, mul, n - 1, k - 1, list);

		return sb.toString();
	}

	private void permutation(StringBuffer sb, int mul, int start, int pos,
			List<Integer> digits) {
		if (start == 0) {
			sb.append(digits.get(1));
			return;
		}
		int num = pos / mul + 1;
		sb.append(digits.get(num));
		digits.remove(num);
		permutation(sb, mul / start, start - 1, pos % mul, digits);
	}

	public static void main(String[] args) {
		System.out.print(new PermutationSequence().getPermutation(6, 400));
	}

}

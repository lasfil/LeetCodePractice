package com.cyandragon.leetcode;
import java.util.ArrayList;

/*
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product. For example, 
 * given the array [2,3,-2,4], 
 * the contiguous subarray [2,3] has the largest product = 6.
 * */
public class MaximumProduct {
	public int maxProduct(int[] A) {
		if (A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];

		int max = A[0];
		ArrayList<Integer> negPosition = new ArrayList<Integer>();
		ArrayList<Integer> zeroPosition = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] < 0)
				negPosition.add(i);
			else if (A[i] == 0)
				zeroPosition.add(i);
			max = Math.max(A[i], max);
		}
		int size = zeroPosition.size();
		if (size > 0) {
			max = Math.max(max, maxProduct(A, 0, zeroPosition.get(0)));
			for (int i = 0; i < size - 1; i++) {
				max = Math.max(
						max,
						maxProduct(A, zeroPosition.get(i) + 1,
								zeroPosition.get(i + 1)));
			}
			max = Math.max(max,
					maxProduct(A, zeroPosition.get(size - 1) + 1, A.length));
		} else
			max = Math.max(max, maxProduct(A, 0, A.length));
		return max;
	}

	public int maxProduct(int[] A, int start, int end) {
		if (start >= end)
			return Integer.MIN_VALUE;
		if (end - start == 1)
			return A[start];

		int max = A[start];
		ArrayList<Integer> negPosition = new ArrayList<Integer>();

		for (int i = start; i < end; i++) {
			if (A[i] < 0)
				negPosition.add(i);

		}

		if (negPosition.size() % 2 == 0) {
			int temp = 1;
			for (int i = start; i < end; i++) {
				temp *= A[i];
				max = Math.max(A[i], Math.max(temp, max));
			}
		} else {
			int temp = A[start];
			for (int i = 1 + start; i < negPosition.get(negPosition.size() - 1); i++) {
				temp *= A[i];
				max = Math.max(A[i], Math.max(temp, max));
			}

			temp = 1;
			for (int i = negPosition.get(0) + 1; i < end; i++) {
				temp *= A[i];
				max = Math.max(A[i], Math.max(temp, max));
			}

		}

		return max;

	}

	public int maxProduct1(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];
		int[] max_local =new int[A.length];
		int[] min_local = new int[A.length];
		max_local[0] = A[0];
		min_local[0] = A[0];
		int global = A[0];
		for (int i = 1; i < A.length; i++) {
			
			max_local[i] = Math.max(Math.max(A[i] * max_local[i-1], A[i]), A[i]
					* min_local[i-1]);
			min_local[i] = Math.min(Math.min(A[i] * max_local[i-1], A[i]), A[i]* min_local[i-1]);
			global = Math.max(global, max_local[i]);
		}
		return global;
	}
}

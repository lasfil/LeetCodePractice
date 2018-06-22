package com.cyandragon.leetcode;

public class MaxChunksToSorted {
	public static void main(String[] args) {
		maxChunksToSorted(new int[] { 1, 0, 2, 3, 4 });
	}

	public static int maxChunksToSorted(int[] arr) {
		int ans = 0, max = 0;
		for (int i = 0; i < arr.length; ++i) {
			max = Math.max(max, arr[i]);
			if (max == i)
				ans++;
		}
		return ans;
	}
}

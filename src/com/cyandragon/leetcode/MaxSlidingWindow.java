package com.cyandragon.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class MaxSlidingWindow {
	@Test
	public void test() {
		new MaxSlidingWindow().maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);

	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		int[] ret = new int[nums.length - k + 1];
		Queue<Integer> heap = new PriorityQueue<Integer>(ret.length, (i1, i2) -> {
			return i2.compareTo(i1);
		});

		for (int i = 0; i < k - 1; i++) {
			heap.add(nums[i]);
		}

		int l = 0;
		int r = k - 1;
		while (r < nums.length) {
			heap.add(nums[r++]);
			ret[l] = heap.peek();
			heap.remove(nums[l++]);
			
		}

		return ret;
	}
}

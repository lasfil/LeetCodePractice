package com.hungerfool.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FindShortestSubArray {
	@Test
	public void test() {
		new FindShortestSubArray().findShortestSubArray(new int[] { 1, 2, 2, 3, 1 });
	}

	class Status {
		int first;
		int last;
		int degree;
		int shortest;

		Status(int first, int last, int degree, int shortest) {
			this.first = first;
			this.last = last;
			this.degree = degree;
			this.shortest = shortest;
		}
	}

	public int findShortestSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Status> count = new HashMap<Integer, Status>();
		int degree = 0;
		int len = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			Status status = count.get(nums[i]);
			if (status == null) {
				status = new Status(i, i, 1, 1);
				count.put(nums[i], status);
			} else {
				status.last = i;
				status.degree += 1;
			}
			if (status.degree > degree) {
				degree = status.degree;
			}
		}
		for (Status s : count.values()) {
			if (s.degree == degree) {
				len = Math.min(len, s.last - s.first + 1);
			}
		}
		return len;
	}
}

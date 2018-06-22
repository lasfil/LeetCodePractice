package com.cyandragon.leetcode;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class Intersect2 {
	@Test
	public void test() {
		new Intersect2().intersect(new int[] { 1, 2 }, new int[] { 1, 1 });
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length * nums2.length == 0) {
			return new int[0];
		}

		if (nums1.length < nums2.length) {
			return intersect(nums2, nums1);
		}

		HashMap<Integer, Integer> count = new HashMap();
		for (int i = 0; i < nums1.length; i++) {
			count.put(nums1[i], count.getOrDefault(nums1[i], 0) + 1);
		}

		int l = 0;
		for (int r = 0; r < nums2.length; r++) {
			if (count.containsKey(nums2[r])) {
				count.put(nums2[r], count.get(nums2[r]) - 1);
				if (count.get(nums2[r]) >= 0)
					nums2[l++] = nums2[r];
			}
		}
		if (l == 0) {
			return new int[0];
		}
		return Arrays.copyOf(nums2, l);
	}
}

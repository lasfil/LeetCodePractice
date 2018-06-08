package com.hungerfool.leetcode;

import org.junit.Test;

public class MaxProduct {
	@Test
	public void test() {
		new MaxProduct().maxProduct(new int[] { 2,2,3 });
	}

	public int maxProduct(int[] nums) {
		int i = 1;
		int product = nums[0];
		int max = nums[0];
		int min = nums[0];
		int maxi, mini;
		while (i < nums.length) {
			maxi = max * nums[i];
			mini = min * nums[i];
			max = Math.max(Math.max(maxi, mini), nums[i]);
			min = Math.min(Math.min(maxi, mini), nums[i]);
			product = Math.max(product, max);
			i++;
		}
		return product;
	}
}

package com.cyandragon.dynamicprogramming;

/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/
public class MaximumSubarray {
	public static int maxSubArray() {
		return maxSubArray(new int[] { -1, -2, 3, 7, 5, -18, -4, 6, 7, 3, -4 });
	}

	public static int maxSubArray(int[] nums) {
		int sum = nums[0];
		int max = sum;

		for (int i = 1; i < nums.length; i++) {

			//sum = Math.max(nums[i], sum + nums[i]);
			if (sum < 0) {
				sum = nums[i];
				if (sum > max) {
					max = sum;
				}
			} else {
				sum += nums[i];
			}

			
		}
		return max;
	}
}

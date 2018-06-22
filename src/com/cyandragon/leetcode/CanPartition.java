package com.cyandragon.leetcode;

import org.junit.Test;

public class CanPartition {
	@Test
	public void test() {
		new CanPartition().canPartition(new int[] { 1, 5, 11, 5 });
	}

	public boolean canPartition(int[] nums) {
		if (nums == null) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 == 1) {
			return false;
		}

		return canPartition(nums, 0, sum / 2, sum / 2);
	}

	private boolean canPartition(int[] nums, int index, int first, int second) {
		if (index == nums.length) {
			return first == 0 && second == 0;
		}
		
		if (first >= nums[index] && canPartition(nums, index + 1, first - nums[index], second)) {
			return true;
		}
		if (second >= nums[index] && canPartition(nums, index + 1, first, second - nums[index])) {
			return true;
		}
		return false;
	}
	
	public boolean checkPartitionPossible(int[] nums, int i, int[] sub){
        if(i < 0)
            return sub[0] == 0 && sub[1] == 0;
        
        for(int k=0; k<sub.length; k++){
            if(sub[k] < nums[i])    
                continue;
            sub[k] -= nums[i];
            if(checkPartitionPossible(nums, i-1, sub)) return true;
            sub[k] += nums[i];
        }
        return false;
    }
}

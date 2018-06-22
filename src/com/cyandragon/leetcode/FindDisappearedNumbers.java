package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindDisappearedNumbers {
	@Test
	public void test() {
		new FindDisappearedNumbers().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
	}
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (nums[v - 1] > 0) {
                nums[v - 1] = -1 * nums[v - 1];
            }
            
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

package com.cyandragon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based. You may
 * assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */

public class TwoSum {
	public class Solution {
	    public int[] twoSum(int[] numbers, int target) {
	        List<Integer> list = new ArrayList<Integer>();
	        for (int i = 0; i < numbers.length; i++) {
	            list.add(numbers[i]);
	        }
	        
	        Arrays.sort(numbers);
	        int s = 0;
	        int e = numbers.length - 1;
	        while (s < e) {
	            if (numbers[s] + numbers[e] == target)
	                break;
	            if (numbers[s] + numbers[e] > target)
	                e--;
	            else if (numbers[s] + numbers[e] < target)
	                s++;
	        }
	        int[] result = new int[2];
	        result[0] = list.indexOf(numbers[s]) + 1;
	        result[1] = list.lastIndexOf(numbers[e]) + 1;
	        Arrays.sort(result);
	       return result;
	    }
	}
}

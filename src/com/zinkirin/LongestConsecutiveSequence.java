package com.zinkirin;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
        int len = num.length;
        if (len < 2)
            return len;
        Arrays.sort(num);
        int longest = 1;
        int count = 1;
        Math.max(longest, count);
        
        
        for (int i = 1; i < len; i++) {
            if (num[i] == num[i-1])
                continue;
            if(num[i] == num[i-1] +1 ) {
                count++;
            } else {
                count = 1;
            }
            
            longest = count > longest ? count : longest;
        }
        
        return longest;
    }
	
	public int longestConsecutive2(int[] num) {
	
       Map<Integer, Boolean> numMap = new HashMap<Integer,Boolean>();
       
        int longest = 1;
        int count = 1;
        
        for (int i = 0; i < num.length; i++) {
        	numMap.put(num[i], false);
        }
        
        for (int i = 0; i < num.length; i++) {
        	int n = num[i];
        	if (numMap.get(n)==false) {
        		count = 1;
        		int low = n - 1;
        		while(numMap.containsKey(low)) {
        			count++;
        			numMap.put(low, true);
        			low = low - 1;
        		}
        		int high = n + 1;
        		while(numMap.containsKey(high)) {
        			count++;
        			numMap.put(high, true);
        			high = high + 1;
        		} 		
        	}
        		
        	longest = count > longest ? count : longest;
        }
       return longest;
    }

}

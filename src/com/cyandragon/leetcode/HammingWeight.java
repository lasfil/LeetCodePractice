package com.cyandragon.leetcode;

public class HammingWeight {
	public static void main(String[] args) {
		hammingWeight(2147483648L);
	}
	 public static int hammingWeight(long n) {
	        int count = 0;
	        while (n > 0) {
	            count += n % 2;
	            n = n >>> 1;
	        }
	        return count;
	    }
}

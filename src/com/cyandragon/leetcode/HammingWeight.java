package com.cyandragon.leetcode;

public class HammingWeight {
	public static void main(String[] args) {
		System.out.println(hammingWeight(55));
		System.out.println(Integer.toBinaryString(-55));
	}
	 public static int hammingWeight(int n) {
	        int count = 0;
	        while (n != 0) {
	            count += n % 2;
	            n = n >>> 1;
	        }
	        return count;
	    }
}

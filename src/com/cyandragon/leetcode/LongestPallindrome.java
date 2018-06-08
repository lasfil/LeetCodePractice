package com.cyandragon.leetcode;
/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 */
public class LongestPallindrome {
	public String longestPalindrome(String s) {
		if (s == null)
			return null;
		int len = s.length();
		if (len == 1)
			return s;
		int max = 0;
		int start = 0;
		int end = 0;
		for (int i = len - 1; i >= 0; i--) {
			int k = i;
			int j = i;
			while (k >= 0 && j < len && s.charAt(k) == s.charAt(j)) {
				if (j - k + 1 > max) {
					start = k;
					end = j;
					 max = j - k + 1;
				}
				k--;
				j++;
			}
			k = i;
			j = i + 1;
			while (k >= 0 && j < len && s.charAt(k) == s.charAt(j)) {
				if (j - k + 1 > max) {
					start = k;
					end = j;
					 max = j - k + 1;
				}
				k--;
				j++;
			}
		}

		return s.substring(start, end + 1);
	}
	
	public static void main(String[] args) {
		String s = "bb";
		
		System.out.println(new LongestPallindrome().longestPalindrome(s));
	}
}

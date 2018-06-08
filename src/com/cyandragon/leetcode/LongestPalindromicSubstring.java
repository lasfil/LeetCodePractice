package com.cyandragon.leetcode;
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int n = s.length();
		if (n <= 2) {
			return s;
		}

		int max = n;

		while (max > 1) {
			int i = 0;
			while (i <= n - max) {
				if (validPalindrome(s, i, i + max))
					break;
				else
					i++;
			}
			if (i <= n - max)
				return s.substring(i, i + max);
			else
				max--;
		}

		return s.substring(0, 1);
	}

	private boolean validPalindrome(String s, int start, int end) {
		int i = start;
		int j = end - 1;
		while (i++ < j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}

		return true;
	}
}

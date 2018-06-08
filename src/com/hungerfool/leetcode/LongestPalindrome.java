package com.hungerfool.leetcode;

public class LongestPalindrome {
	

	int left = 0;
	int right = 1;

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int start = 0;
		int end = 0;
		int max = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			start = i;
			end = i;
			while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
				start--;
				end++;
			}
			if (end - start - 2 > max) {
				max = end - start - 2;
				left = start + 1;
				right = end;
			}

			start = i;
			end = i + 1;
			while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
				start--;
				end++;
			}
			if (end - start - 2 > max) {
				max = end - start - 2;
				left = start + 1;
				right = end;
			}

		}

		return s.substring(left, right);
	}
}

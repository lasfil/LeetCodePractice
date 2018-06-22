package com.cyandragon.leetcode;

import org.junit.Test;

public class LongestPalindrome {
	@Test
	public void test() {
		new LongestPalindrome().longestPalindrome("ccc");
	}
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 1) {
			return s;
		}
		char[] chars = s.toCharArray();
		int max = 1;
		String ret = "";
		for (int i = 0; i < s.length() - 1; i++) {
			int l = i;
			int r = i;
			while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
				l--;
				r++;
			}
			int len = r - l - 1;
			if (max < len) {
				ret = s.substring(l + 1, r);
			}
			l = i;
			r = i + 1;
			while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
				l--;
				r++;
			}
			len = r - l - 1;
			if (max < len) {
				ret = s.substring(l + 1, r);
			}
		}
		return ret;
	}
}

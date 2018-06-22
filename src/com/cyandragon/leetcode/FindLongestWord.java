package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindLongestWord {
	@Test
	public void test() {
		new FindLongestWord().findLongestWord("abpcplea",
				Arrays.asList(new String[] { "ale", "apple", "monkey", "plea" }));
	}

	public String findLongestWord(String s, List<String> d) {
		if (s == null || d == null || s.length() == 0 || d.size() == 0) {
			return "";
		}
		String ret = "";
		for (String str : d) {
			if (isSubString(s, str) && isBigger(str, ret)) {
				ret = str;
			}
		}
		return ret;
	}

	private boolean isSubString(String s1, String s2) {
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}
		return j == s2.length();
	}

	private boolean isBigger(String s1, String s2) {
		return s1.length() > s2.length() || s1.compareTo(s2) > 0;
	}
}

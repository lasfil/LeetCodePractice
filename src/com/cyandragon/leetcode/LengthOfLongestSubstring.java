package com.cyandragon.leetcode;

import java.util.HashMap;

import org.junit.Test;

public class LengthOfLongestSubstring {
	@Test
	public void test() {
		new LengthOfLongestSubstring().lengthOfLongestSubstring("uddu");
	}
	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		if (s.length() < 2) {
			return s.length();
		}

		HashMap<Character, Integer> countMap = new HashMap();
		char[] chars = s.toCharArray();

		int i = 0;
		int j = 0;
		int max = 0;
		while (j < chars.length) {
			if (countMap.containsKey(chars[j])) {
				i = countMap.get(chars[j]) + 1;
				
			} 
			max = Math.max(j - i + 1, max);
			countMap.put(chars[j], j);
			j++;
		}
		max = Math.max(j - i, max);
		return max;
	}
}

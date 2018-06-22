package com.cyandragon.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class MinWindow {
	@Test
	public void test() {
		new MinWindow().minWindow("aa", "aa");
	}
	public String minWindow(String s, String t) {
		String ret = "";
		if (s == null || s.length() == 0) {
			return ret;
		}

		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		int len = t.length();
		for (int i = 0; i < len; i++) {
			char c = t.charAt(i);
			count.put(c, count.getOrDefault(c, 0) + 1);
		}
		int l = 0;
		int r = 0;
		int charToFind = len;
		int min = Integer.MAX_VALUE;
		while (r < s.length()) {
			char cr = s.charAt(r);
			if (count.containsKey(cr)) {
				count.put(cr, count.get(cr) - 1);
				if (count.get(cr) == 0) {
					charToFind--;
				}
			}
			r++;
			while (charToFind == 0) {
				if (r - l < min) {
					ret = s.substring(l, r);
					min = ret.length();
				}
				char cl = s.charAt(l);
				if (count.containsKey(cl)) {
					count.put(cl, count.get(cl) + 1);
					if (count.get(cl) > 0) {
						charToFind++;
					}
				}
				l++;
			}
		}

		return ret;
	}
}

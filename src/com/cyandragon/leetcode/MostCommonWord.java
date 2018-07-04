package com.cyandragon.leetcode;

import java.util.HashMap;

import org.junit.Test;

public class MostCommonWord {
	@Test
	public void test() {

		mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" });
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		char[] pun = new char[] {'!','?',',',';','.'};
        for (char c : pun) {
            paragraph = paragraph.replace(c, ' ');
        }
		String[] words = paragraph.split(" ");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String s : words) {
			map.put(s.toLowerCase(), map.getOrDefault(s.toLowerCase(), 0) + 1);
		}

		int max = 0;
		for (String s : banned) {
			if (map.containsKey(s)) {
				map.remove(s);
			}
		}
		String ret = "";
		for (String s : map.keySet()) {
			if (map.get(s) > max) {
				max = map.get(s);
				ret = s;
			}
		}
		return ret;
	}
}

package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FindAnagrams {
	@Test
	public void test() {
		new FindAnagrams().findAnagrams("cbaebabacd", "abc");
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ret = new ArrayList<Integer>();
		if (s == null || p == null || s.length() == 0) {
			return ret;
		}
		HashMap<Character, Integer> charCount = new HashMap();
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}
		int charToFind = charCount.size();
		int lenp = p.length();
		char[] charS = s.toCharArray();
		int l = 0;
		int r = 0;
		while (r < charS.length) {
			if (charCount.containsKey(charS[r])) {
				int count = charCount.get(charS[r]);
				count = count - 1;
				if (count == 0) {
					charToFind--;
				}
				charCount.put(charS[r], count);
			}
			r++;
			while (charToFind == 0) {
				if (r - l == lenp)
					ret.add(l);
				if (charCount.containsKey(charS[l])) {
					int count = charCount.get(charS[l]);
					count += 1;
					if (count > 0) {
						charToFind++;
					}
				}
				l++;
			}
			

		}
		return ret;
	}

	public List<Integer> findAnagrams1(String s, String t) {
		List<Integer> result = new LinkedList<>();
		if (t.length() > s.length())
			return result;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int charToFind = map.size();

		int begin = 0, end = 0;
		int head = 0;
		int len = Integer.MAX_VALUE;
		int sum = t.length();
		while (end < s.length()) {
			System.out.println(s.substring(begin, end) + " :" + charToFind);
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					charToFind--;
			}
			end++;

			while (charToFind == 0) {
				System.out.println(s.substring(begin, end) + " :" + charToFind);
				if (end - begin == t.length()) {
					result.add(begin);
				}
				char tempc = s.charAt(begin);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						charToFind++;
					}
				}

				begin++;
			}

		}
		return result;
	}
}

package com.cyandragon.leetcode;
import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 */
public class LongestSubNoRepeat {
	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		int len = s.length();
		if (len < 2)
			return len;

		int start = 0;
		int i = start + 1;
		int max = 1;
		while (start < len - 1 && i < len) {
			String sub = s.substring(start, i);
			char c = s.charAt(i);
			int repeat = sub.lastIndexOf(c);

			if (repeat != -1) {
				max = Math.max(max, sub.length());
				start += repeat + 1;
			}
			i++;
		}

		return Math.max(max, i - start);
	}

	public int lengthOfLongestSubstring1(String s) {
		if (s.length() == 0)
			return 0;
		int start = 0, j = 0;
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		while (j < s.length()) {
			char c = s.charAt(j);
			if (!map.containsKey(c)) {
				map.put(c, j);
			} else {
				int length = j - start;
				if (result < length) {
					result = length;
				}
				int repeat = map.get(c);
				System.out.println(c + " repeat at " + repeat + "start at "
						+ start);
				start = Math.max(start, repeat + 1);
				map.put(c, j);
			}
			j++;
		}

		if (result < j - start)
			return j - start;
		else
			return result;
	}

	public static void main(String[] args) {
		String s = "aabcdecbaefdbcab";
		System.out
				.println(new LongestSubNoRepeat().lengthOfLongestSubstring(s));
		System.out.println(new LongestSubNoRepeat()
				.lengthOfLongestSubstring1(s));
	}
}

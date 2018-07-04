package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/*
 A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "cababcbacadefegdehijhklij" 0-8,9-13,14-21
            

Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
*/
public class PartitionLabels {
	public static List<Integer> partitionLabels() {
		return partitionLabels("ababcbacadefegdehijhklij");
	}

	public static List<Integer> partitionLabels(String S) {
		List<Integer> result = new ArrayList<Integer>();

		int[] start = new int[256];
		int[] end = new int[256];
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (start[c] == 0) {
				start[c] = i + 1;
			}
		}
		for (int i = S.length() - 1; i >= 0; i--) {
			char c = S.charAt(i);
			if (end[c] == 0) {
				end[c] = i + 1;
			}
		}

		int left = 1;
		int right = 1;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (start[c] > right) {
				result.add(right - left + 1);
				left = start[c];
				right = end[c];
			} else {
				if (end[c] > right) {
					right = end[c];
				}
				if (start[c] < left) {
					left = start[c];

				}
			}
		}
		result.add(right - left + 1);
		return result;
	}

	public static List<Integer> partitionLabels1(String S) {
		int[] pos = new int[26];
		List<Integer> ret = new ArrayList<Integer>();
		char[] charS = S.toCharArray();
		int s = 0;
		int e = 0;
		while (e < charS.length) {
			pos[charS[e] - 'a'] = e;
		}
		e = 0;
		while (s < charS.length) {
			e = pos[charS[s] - 'a'];
			for (int i = s + 1; i < e; i++) {
				int last = pos[charS[i] - 'a'];
				if (last > e) {
					e = last;
				}
			}
			ret.add(e - s + 1);
			s = e + 1;
		}
		return ret;
	}

	@Test
	public void test() {
		partitionLabels1("ababcbacadefegdehijhklij");
	}
}

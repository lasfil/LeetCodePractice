package com.cyandragon.leetcode;
import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 * great / \ gr eat / \ / \ g r e at / \ a t To scramble the string, we may
 * choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".
 *
 * rgeat / \ rg eat / \ / \ r g e at / \ a t We say that "rgeat" is a scrambled
 * string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it
 * produces a scrambled string "rgtae".
 *
 * rgtae / \ rg tae / \ / \ r g ta e / \ t a We say that "rgtae" is a scrambled
 * string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		if (s1.equals(s2))
			return true;
		int m = s1.length();
		int n = s2.length();
		if (m != n)
			return false;

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		// 如果出现不同字符返回false
		if (!new String(c1).equals(new String(c2)))
			return false;

		for (int i = 1; i < m; i++) {
			// 暴力组合找到一条分界线，s1的前半段和s2同样分割的前半段互为scamble，
			// 两个后半段也互为scramble，整个都为scramble
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i)))
				return true;
			// s2与s1同样分割方法不成立的话，s2与s1对称分割，再次验证
			if (isScramble(s1.substring(0, i), s2.substring(m - i))
					&& isScramble(s1.substring(i), s2.substring(0, m - i)))
				return true;
		}

		return false;
	}

	public boolean isScramble1(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;

		int[] A = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			++A[s1.charAt(i) - 'a'];
		}

		for (int j = 0; j < s2.length(); j++) {
			--A[s2.charAt(j) - 'a'];
		}

		for (int k = 0; k < 26; k++) {
			if (A[k] != 0)
				return false;
		}

		for (int i = 1; i < s1.length(); i++) {
			boolean result = isScramble1(s1.substring(0, i), s2.substring(0, i))
					&& isScramble1(s1.substring(i), s2.substring(i));
			result = result
					|| (isScramble1(s1.substring(0, i),
							s2.substring(s2.length() - i, s2.length())) && isScramble1(
							s1.substring(i), s2.substring(0, s2.length() - i)));
			if (result)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println(new ScrambleString().isScramble1(
				"abcdefghijklmnopq", "abcdefghijklmnopq"));
	}
}

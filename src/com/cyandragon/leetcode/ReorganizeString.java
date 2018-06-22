package com.cyandragon.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ReorganizeString {
	@org.junit.Test
	public void test() {
		System.out.println(new ReorganizeString().reorganizeString("fjakdsafjklewlafjjjjjjtyidwsxbgggggddddssuuuu"));
		System.out.println(new ReorganizeString().reorganizeString1("fjakdsafjklewlafjjjjjjtyidwsxbgggggddddssuuuu"));
	}

	public String reorganizeString1(String S) {
		if (S == null || S.length() < 2) {
			return S;
		}
		int len = S.length();
		HashMap<Character, Integer> count = new HashMap();
		for (int i = 0; i < len; i++) {
			char c = S.charAt(i);
			count.put(c, count.getOrDefault(c, 0) + 1);
			if (count.get(c) - 1 > len - count.get(c)) {
				return "";
			}
		}
		char[] charS = S.toCharArray();
		Arrays.sort(charS);
		int l = 0;
		int r = len - 1;
		StringBuilder odd = new StringBuilder();
		for (int i = 0; i < len; i+=2) {
			odd.append(charS[i]);
		}
		for (int i = 1; i < len; i+=2) {
			odd.append(charS[i]);
		}
		return odd.toString();
	}

	public String reorganizeString(String S) {
		int N = S.length();
		int[] counts = new int[26];
		for (char c : S.toCharArray())
			counts[c - 'a'] += 100;
		for (int i = 0; i < 26; ++i)
			counts[i] += i;
		// Encoded counts[i] = 100*(actual count) + (i)
		Arrays.sort(counts);

		char[] ans = new char[N];
		int t = 0;
		for (int code : counts) {
			int ct = code / 100;
			char ch = (char) ('a' + (code % 100));
			if (ct > (N + 1) / 2)
				return "";
			for (int i = 0; i < ct; ++i) {
				if (t >= N)
					t = 1;
				ans[t] = ch;
				t += 2;
			}
		}

		return String.valueOf(ans);
	}
}

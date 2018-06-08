package com.cyandragon;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S and a string T, find all the window in S which will contain
 * all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODECBANC" T = "ABC" Minimum window is "CBA".
 * 
 * Note:
 * 
 * If there is no such window in S that covers all characters in T, return the
 * emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 */
public class WindowSubstring {
	public List<Integer> minWindow(String S, String T) {
		int[] needFound = new int[256];
		boolean[] contains = new boolean[256];
		int diffCount = T.length();
		int length = S.length();
		List<Integer> result = new ArrayList<Integer>();
		if (length == 0 || diffCount == 0)
			return result;
		for (int l = 0; l < diffCount; l++) {
			needFound[T.charAt(l)]++;
			contains[T.charAt(l)] = true;
		}
		int k = 0, j = 0;
		ArrayList<Integer> pos = new ArrayList<Integer>();
		while (j < length) {
			char c = S.charAt(j);
			if (contains[c]) {
				// needFound[c]大于0，表示还没有完全找到T中的c
				// 所以在第j个字符处又找到一个，diffCount减少一个
				// needFound[c]小于等于0的时候，是多余的c
				if (0 < needFound[c])
					diffCount--;
				needFound[c]--;
				pos.add(j);

			} 
			while (diffCount == 0) {
				int i = pos.get(k++);
				char h = S.charAt(i);
				// needFound[h]++表示假设从第i＋1位算起
				// 如果needFound[h] > 0表示第i＋1位到第j位之间不存在h
				// 证明S的第i位到第j位包含一个完整的T
				// 否则needFound[h]++后还是小于等于0，表示第i＋1位到第j位之间存在h, 第i位的h不用考虑

				needFound[h]++;
				if (needFound[h] > 0) {
					System.out.println(i + " " + j);
					if (j - i == T.length() - 1) {
						result.add(i);
					}
					diffCount++;
				}

			}
			j++;
		}
		return result;
	}

	public static void main(String[] args) {

		String S = "aakabbcaababakabbcaf";
		String T = "aaabbc";
		System.out.println(new WindowSubstring().minWindow(S, T));
		// System.out.println(new WindowSubstring().minWindow4(S, T));
		// System.out.println(new MinimumWindowSubstring().minWindow1(s1, t1));
		// System.out.println(new MinimumWindowSubstring().minWindow2(s1, t1));
	}
}

package com.cyandragon;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note:
 * 
 * If there is no such window in S that covers all characters in T, return the
 * emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		int[] needFound = new int[256];
		boolean[] contains = new boolean[256];
		int diffCount = T.length();
		int length = S.length();
		if (length == 0 || diffCount == 0)
			return "";
		for (int l = 0; l < diffCount; l++) {
			needFound[T.charAt(l)]++;
			contains[T.charAt(l)] = true;
		}
		int k = 0, j = 0;
		int from = -1;
		int to = length;
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
				if (contains[h]) {
					needFound[h]++;
					if (needFound[h] > 0) {
						System.out.println(i + " " + j);
						if (j - i < to - from) {
							from = i;
							to = j;

						}
						diffCount++;
					}
				}
			}
			j++;
		}
		return from == -1 ? "" : S.substring(from, to + 1);
	}

	// 暴力组合法，超时
	public String minWindow4(String S, String T) {
		if (S == null || T == null)
			return null;
		int m = S.length();
		int n = T.length();
		if (m < n)
			return "";
		StringBuffer sb = new StringBuffer();

		int from = -1;
		int to = m;
		for (int i = 0; i < m; i++) {
			char c = S.charAt(i);
			int pos = T.indexOf(c);
			if (pos != -1) {
				sb = new StringBuffer(T);
				sb.deleteCharAt(pos);
				for (int j = i + 1; j < m; j++) {
					int index = sb.indexOf(S.substring(j, j + 1));
					if (index != -1) {
						sb.deleteCharAt(index);
					}
					if (j - i > to - from)
						break;
					if (sb.length() == 0) {
						if (j - i < to - from) {
							from = i;
							to = j;
						}
					}
				}
			}
		}

		return from == -1 ? "" : S.substring(from, to + 1);
	}

	public String minWindow1(String S, String T) {
		int[] hasFound = new int[256];
		int[] needFound = new int[256];
		int diffCount = T.length();
		int length = S.length();
		String window = "";
		int size = Integer.MAX_VALUE;
		if (length == 0 || diffCount == 0)
			return window;
		for (int l = 0; l < diffCount; l++) {
			needFound[T.charAt(l)]++;
		}
		int i = 0, j = 0;
		while (j < length) {
			char c = S.charAt(j);
			if (needFound[c] > 0 && ++hasFound[c] <= needFound[c]) {
				diffCount--;
			}
			if (diffCount == 0) {
				while (i <= j) {
					char h = S.charAt(i);
					i++;
					if (needFound[h] > 0) {
						// hasFound[h] >= needFound[h]表示i到j中还存在多余的h
						// 因为i向后挪动一位，所以hasFound[h]需要减一
						hasFound[h]--;
						// 如果hasFound[h] < needFound[h]
						// 表示i到j中不再有h，此时i － 1到j中应该只包含一个T
						if (hasFound[h] < needFound[h]) {
							if (j - i + 1 < size) {
								size = j - i + 1;
								window = S.substring(i - 1, j + 1);
							}
							diffCount++;
							break;
						}
					}
				}
			}
			j++;
		}
		return window;
	}

	public String minWindow2(String S, String T) {
		String res = "";
		if (S == null || T == null || S.length() == 0 || T.length() == 0)
			return res;

		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			if (!dict.containsKey(T.charAt(i)))
				dict.put(T.charAt(i), 1);
			else
				dict.put(T.charAt(i), dict.get(T.charAt(i)) + 1);
		}

		int count = 0;
		int pre = 0;
		int minLen = S.length() + 1;
		for (int i = 0; i < S.length(); i++) {
			if (dict.containsKey(S.charAt(i))) {
				dict.put(S.charAt(i), dict.get(S.charAt(i)) - 1);
				if (dict.get(S.charAt(i)) >= 0)
					count++;

				while (count == T.length()) {
					if (dict.containsKey(S.charAt(pre))) {
						dict.put(S.charAt(pre), dict.get(S.charAt(pre)) + 1);

						if (dict.get(S.charAt(pre)) > 0) {
							if (minLen > i - pre + 1) {
								res = S.substring(pre, i + 1);
								minLen = i - pre + 1;
							}
							count--;
						}
					}
					pre++;
				}
			}// end for if(dict.containsKey(S.charAt(i)))
		}
		return res;
	}

	public String minWindow3(String S, String T) {
		int[] needFound = new int[256];
		boolean[] contains = new boolean[256];
		int diffCount = T.length();
		int length = S.length();
		if (length == 0 || diffCount == 0)
			return "";
		for (int l = 0; l < diffCount; l++) {
			needFound[T.charAt(l)]++;
			contains[T.charAt(l)] = true;
		}
		int i = 0, j = 0;
		int from = -1;
		int to = length;
		while (j < length) {
			char c = S.charAt(j);
			if (contains[c]) {
				needFound[c]--;
				if (0 <= needFound[c])
					diffCount--;
			}
			if (diffCount == 0) {
				while (i <= j) {
					char h = S.charAt(i);
					i++;
					if (contains[h])
						needFound[h]++;
					if (needFound[h] > 0) {
						if (j - i + 1 < to - from) {
							from = i - 1;
							to = j;
						}
						diffCount++;

						break;
					}
				}
			}
			j++;
		}
		return from == -1 ? "" : S.substring(from, to + 1);
	}

	public static void main(String[] args) {

		String S = "kgafbbbibaaccadhacccktakjbhlccaaaakccbbbbgajckcaaaylgdracfzjduybcghkoabbmabbrbfbkoaaaoawqwcgaurizbliesjnveoxmvj";
		String T = "aaabbc";
		System.out.println(new MinimumWindowSubstring().minWindow(S, T));
		System.out.println(new MinimumWindowSubstring().minWindow4(S, T));
		// System.out.println(new MinimumWindowSubstring().minWindow1(s1, t1));
		// System.out.println(new MinimumWindowSubstring().minWindow2(s1, t1));
	}
}

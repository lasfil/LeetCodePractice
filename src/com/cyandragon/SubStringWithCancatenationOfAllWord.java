package com.cyandragon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubStringWithCancatenationOfAllWord {
	public List<Integer> findSubstring(String S, String[] L) {
		if (S == null || L == null)
			return null;
		List<Integer> result = new ArrayList<Integer>();
		int m = S.length();
		int n = L.length;

		if (m == 0 || n == 0) {
			return result;
		}

		int size = L[0].length();
		if (m < n * size)
			return result;
		HashMap<String, Integer> need = new HashMap<String, Integer>();

		for (String str : L) {
			if (need.containsKey(str)) {
				need.put(str, need.get(str) + 1);
			} else {
				need.put(str, 1);
			}
		}
		int i = 0;
		while (i <= m - size * n) {
			if (valid(S.substring(i, i + n * size), L,
					new HashMap<String, Integer>(need))) {
				result.add(i);
			}
			i++;
		}

		return result;
	}

	private boolean valid(String str, String[] L, HashMap<String, Integer> need) {
		int found = 0;
		for (int i = 0; i < str.length(); i += L[0].length()) {
			String sub = str.substring(i, i + L[0].length());
			if (need.containsKey(sub) && need.get(sub) > 0) {
				found++;
				need.put(sub, need.get(sub) - 1);
			} else {
				return false;
			}
		}

		return found == L.length;
	}

	public List<Integer> findSubstring1(String S, String[] L) {
		if (S == null || L == null)
			return null;
		List<Integer> result = new ArrayList<Integer>();
		int m = S.length();
		int n = L.length;

		if (m == 0 || n == 0) {
			return result;
		}

		int size = L[0].length();
		if (m < n * size)
			return result;

		HashMap<String, Integer> need = new HashMap<String, Integer>();

		for (String str : L) {
			if (need.containsKey(str)) {
				need.put(str, need.get(str) + 1);
			} else {
				need.put(str, 1);
			}
		}
		
		int i = 0;
		int found = n;
		int k = 0;
		ArrayList<Integer> pos = new ArrayList<Integer>();
		while (i + size <= m) {
			String sub = S.substring(i, i + size);
			if (need.containsKey(sub)) {
				int tmp = need.get(sub);
				if (tmp > 0) {
					found--;
				}
				need.put(sub, tmp - 1);
				pos.add(i);
				i += size;
			} else {
				i++;
			}
			
			while(found == 0) {
				int from = pos.get(k++);
				String key = S.substring(from, from + size);
				need.put(key, need.get(key) + 1);
				if (need.get(key) > 0) {
					if (i - from == size * n) {
						result.add(from);
					}
					found++;
				}
			}
			
			
		}

		return result;
	}

	public static void main(String[] args) {
//		String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
//		String[] l = new String[] { "fooo", "barr", "wing", "ding", "wing" };
		 String s = "aaaaaaaaaa";
		 String[] l = new String[] { "aaa", "aaa" };
//		String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
//		String[] l = new String[] { "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
//				"ba", "ab", "ba" };
		System.out.println(new SubStringWithCancatenationOfAllWord()
				.findSubstring(s, l));
		System.out.println(new SubStringWithCancatenationOfAllWord()
				.findSubstring1(s, l));
	}
}

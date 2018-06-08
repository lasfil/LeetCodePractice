package com.zinkirin;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreak2 {
	public List<String> wordBreak(String s, Set<String> dict) {
		int max = 0;
		for (String w : dict) {
			max = Math.max(w.length(), max);
		}
		int len = s.length();
		List<Integer>[] strMap = new List[len + 1];
		strMap[0] = new ArrayList<Integer>();
		for (int i = 1; i <= len; i++) {
			for (int j = i - max > 0 ? i - max : 0; j < i; j++) {
				if (strMap[j] != null && dict.contains(s.substring(j, i))) {
					if (strMap[i] == null)
						strMap[i] = new ArrayList<Integer>();
					strMap[i].add(j);
				}
			}
		}
		List<String> result = new ArrayList<String>();
		if (strMap[len] == null)
			return result;
		StringBuffer sb = new StringBuffer(s);
		dfs(strMap, result, len, sb);

		return result;
	}

	private void dfs(List<Integer>[] strMap, List<String> result, int start,
			StringBuffer sb) {
		List<Integer> next = strMap[start];
		if (next == null)
			return;
		for (int i : next) {
			if (i == 0) {
				result.add(sb.toString());
				continue;
			}
			if (strMap[i] != null) {
				StringBuffer nsb = new StringBuffer(sb);
				nsb.insert(i, " ");
				dfs(strMap, result, i, nsb);
			}
		}

	}
	
	public static void main(String[] args) {
		String[] A = new String[] { "a", "aa", "aaaa"}; //"aaaa", "aaaaa",
//				"aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
		//String[] B = new String[] { "cat", "cats", "and", "sand", "dog"};
		Set<String> dict = new HashSet<String>();
		for (String s : A)
			dict.add(s);
		System.out.println(new WordBreak2().wordBreak(
		
		 "aaaaaaa", dict));

	}
}

package com.zinkirin;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return the minimum cuts needed for a palindrome partitioning of
 * s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 * D[i] = min(1 + D[j + 1], D[i]) i<=j<n s[i, j] is palindrome
 */
public class PalindromePartitioning2 {
	public int minCut(String s) {
		if (s == null)
			return 0;
		int len = s.length();
		if (len == 0 || len == 1)
			return 0;

		if (len == 2) {
			if (s.charAt(0) == s.charAt(1))
				return 0;
			else
				return 1;
		}

		List<Integer>[] index = new List[len];
		int[] minCut = new int[len + 1];
		for (int i = len; i >= 0; i--) {
			minCut[i] = len - i;
		}
		for (int i = len - 1; i >= 0; i--) {
	        int j = i;
			int k = i;
			while (k >= 0 && j < len && s.charAt(k) == s.charAt(j)) {
				if (index[k] == null) {
					index[k] = new ArrayList<Integer>();
					index[k].add(k);
				}
				index[k].add(j);
				
					minCut[k] = Math.min(minCut[k], minCut[j + 1] + 1);
				k--;
				j++;
			}
			j = i + 1;
		    k = i;
			while (k >= 0 && j < len && s.charAt(k) == s.charAt(j)) {
				if (index[k] == null) {
					index[k] = new ArrayList<Integer>();
					index[k].add(k);
				}
				index[k].add(j);
				
					minCut[k] = Math.min(minCut[k], minCut[j + 1] + 1);
				k--;
				j++;
			}

		
		}

		return minCut[0] - 1;
	}

	public int minCut2(String s) {
		int length = s.length();
		int[] dp = new int[length + 1];
		boolean[][] parlin = new boolean[length][length];

		for (int i = length; i >= 0; i--) {
			dp[i] = length - i;
		}

		for (int i = length - 1; i >= 0; i--) {
			for (int j = i; j < length; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || parlin[i + 1][j - 1])) {
					parlin[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}

		return dp[0] - 1;
	}

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaa";
		String s1 = "cddddccdbabcbcb";
		System.out.println(Calendar.getInstance().getTimeInMillis());
		new PalindromePartitioning2().minCut2(s);
		System.out.println(Calendar.getInstance().getTimeInMillis());
		new PalindromePartitioning2().minCut(s);
		System.out.println(Calendar.getInstance().getTimeInMillis());

	}
}

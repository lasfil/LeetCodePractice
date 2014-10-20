import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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
		int[] minCut = new int[len];
		for (int i = len - 1; i >= 0; i--) {
			minCut[i] = len - 1 - i;
		}
		for (int i = len - 1; i >= 0; i--) {
			if (index[i] == null) {
				index[i] = new ArrayList<Integer>();
				index[i].add(i);
				if (i + 1 < len)
					minCut[i] = Math.min(minCut[i], minCut[i + 1] + 1);
			}

			int j = i + 1;
			int k = i;
			while (k >= 0 && j < len && s.charAt(k) == s.charAt(j)) {
				if (index[k] == null) {
					index[k] = new ArrayList<Integer>();
					index[k].add(i);
				}
				index[k].add(j);
				if (j == len - 1)
					minCut[k] = 0;
				else
					minCut[k] = Math.min(minCut[k], minCut[j + 1] + 1);
				k--;
				j++;
			}

			j = i + 2;
			k = i;
			while (k >= 0 && j < len && s.charAt(k) == s.charAt(j)) {
				if (index[k] == null) {
					index[k] = new ArrayList<Integer>();
					index[k].add(i);
				}
				index[k].add(j);
				if (j == len - 1)
					minCut[k] = 0;
				else
					minCut[k] = Math.min(minCut[k], minCut[j + 1] + 1);
				k--;
				j++;
			}
		}

		return minCut[0];
	}

	private boolean isPalindrome(String s, int start, int end) {

		while (start < end) {
			if (s.charAt(start++) != s.charAt(--end))
				return false;
		}

		return true;
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
		String s1 = "cdd";
		System.out.println(Calendar.getInstance().getTimeInMillis());
		new PalindromePartitioning2().minCut2(s);
		System.out.println(Calendar.getInstance().getTimeInMillis());
		new PalindromePartitioning2().minCut(s1);
		System.out.println(Calendar.getInstance().getTimeInMillis());

	}
}

package com.cyandragon.leetcode;
/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") -> false isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false isMatch("aa", "a*") -> true isMatch("aa", ".*")
 * -> true isMatch("ab", ".*") -> true isMatch("aab", "c*a*b") -> true
 *
 */
public class RegularExpressionMatching {

	public boolean isMatch1(String s, String p) {
		if (s == null || p == null)
			return false;
		int m = s.length();
		int n = p.length();
		if (n == 0)
			return m == 0;
		if (p.charAt(0) == '*')
			return false;

		int i = m - 1;
		int j = n - 1;

		while (i >= 0) {
			if (j >= 0 && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
				// p的第j位字符不在*前面，向前匹配一位
				j--;
				i--;
			} else if (j >= 0 && p.charAt(j) == '*') {
				// 第j位是*，那么需要挨个判断s中末尾跟pre能匹配的一位字符都去掉后跟j之前两位的子串是否匹配
				// 比如aabbb ab*就需要判断aabbb a，aabb a， aab a，aa a
				// 都不匹配最后会返回false，有一个匹配返回true
				char pre = p.charAt(j - 1);
				j -= 2;

				while (i >= 0 && (s.charAt(i) == pre || pre == '.')) {
					if (isMatch1(s.substring(0, i + 1), p.substring(0, j + 1)))
						return true;
					i--;
				}
			} else {
				// j 小于0，或者第j位既不是.也不是*也不等于第i位
				return false;
			}
		}
		while (j > 0 && p.charAt(j) == '*') {
			j -= 2;
		}

		return j == -1;
	}

	public boolean isMatch(String s, String p) {
		return isMatch(s, 0, p, 0);
	}

	private boolean isMatch(String s, int i, String p, int j) {
		// System.out.println(s.substring(i) + " : " + p.substring(j));
		int ls = s.length();
		int lp = p.length();
		if (j == lp) {
			return i == ls;
		}
		if ((j < lp - 1 && p.charAt(j + 1) != '*') || j == lp - 1) {
			return (i < ls && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
					&& isMatch(s, i + 1, p, j + 1);
		}
		while ((i < ls && s.charAt(i) == p.charAt(j))
				|| (p.charAt(j) == '.' && i < ls)) {
			if (isMatch(s, i, p, j + 2))
				return true;
			i++;
		}
		return isMatch(s, i, p, j + 2);
	}

	public static void main(String[] args) {
		// System.out.println(new RegularExpressionMatching().isMatch1("",
		// "a.*"));
		// System.out.println(new RegularExpressionMatching().isMatch("",
		// "a.*"));
		// System.out.println(new RegularExpressionMatching().isMatch1("afefeg",
		// "a.*"));
		// System.out.println(new RegularExpressionMatching().isMatch("afefeg",
		// "a.*"));
		// System.out.println(new RegularExpressionMatching().isMatch1("afefeg",
		// "*a.*"));
		// System.out.println(new RegularExpressionMatching().isMatch("afefeg",
		// "*a.*"));
		System.out.println(new RegularExpressionMatching().isMatch1("baa",
				"aa*"));
		System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
		System.out.println(new RegularExpressionMatching().isMatch("aaa",
				"ab*a*c*a"));
		System.out.println(new RegularExpressionMatching().isMatch1("aaa",
				"ab*a*c*a"));
		System.out.println(new RegularExpressionMatching().isMatch(
				"aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
		System.out.println(new RegularExpressionMatching().isMatch1(
				"aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
		// System.out.println(new RegularExpressionMatching().isMatch("aabb",
		// ".*c*a*b*"));
		// System.out.println(new
		// RegularExpressionMatching().isMatch1("wdqdaabb",
		// "b*.*c*a*b*"));

	}
}

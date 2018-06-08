package com.zinkirin;
/*Implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		StringBuffer sb = new StringBuffer(s);
		StringBuffer pb = new StringBuffer(p);
		int m = sb.length();
		int n = pb.length();
		// 先从两头单个字母匹配，直到碰到*为止
		while (n > 0 && m > 0 && pb.charAt(0) != '*') {
			if (pb.charAt(0) == '?' || sb.charAt(0) == pb.charAt(0)) {
				sb.deleteCharAt(0);
				pb.deleteCharAt(0);
				m = sb.length();
				n = pb.length();
			} else
				return false;

		}

		while (n > 0 && m > 0 && pb.charAt(pb.length() - 1) != '*') {
			if (pb.charAt(pb.length() - 1) == '?'
					|| sb.charAt(sb.length() - 1) == pb.charAt(pb.length() - 1)) {
				sb.deleteCharAt(sb.length() - 1);
				pb.deleteCharAt(pb.length() - 1);
				m = sb.length();
				n = pb.length();
			} else
				return false;
		}

		s = sb.toString();
		p = pb.toString();
		if (n == 0)
			return m == 0;
		// any记录是否有*，single记录？的个数
		boolean any = false;
		int j = 0;
		int i = 0;

		while (j < n) {

			char cp = p.charAt(j);
			// p中遇到？j向后移动一位，i向后移动一位
			if (cp == '?') {
				i++;
				j++;
				continue;
			}
			// p中遇到*, any设为true,j向后移动一位
			if (cp == '*') {
				any = true;
				j++;
				continue;
			}

			if (i >= m)
				return false;
			int k = 1;
			// p中是字母的话，从j到下一个'?'或'*'做为一个窗口
			// 首先确定窗口大小k,
			while (k + j < n) {
				char next = p.charAt(k + j);
				if (next == '?' || next == '*')
					break;
				k++;
				if (i + k > m)
					return false;
			}
			// 然后从i开始匹配k个字符与j后的k个字符,
			// any为false的话只能匹配一次，
			// 为true的话i中窗口可以顺序向后移动直到匹配成功或者i + k > m返回false
			while (!s.substring(i, i + k).equals(p.substring(j, j + k))) {
				if (any == false)
					return false;
				i++;
				if (i + k > m)
					return false;
			}
			j = j + k;
			i = i + k;
			any = false;
		}

		if (any)
			// 匹配完成后如果最后一位字母后边有*，i应该小于等于m
			return m >= i;
		else
			// 匹配完成后如果最后一位字母后边没有*，i应该等于m
			return m == i;
	}

	public boolean isMatch1(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j++;
				mark = i;
			} else if (star != -1) {
				// 遇到不匹配的情况j从上一个＊号从新开始，i从mark的地方重新开始，mark也向后移动一位
				j = star + 1;
				i = ++mark;
			} else {
				// p中没有'*'遇到不匹配的情况
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}

	public static void main(String[] args) {
		String s = "misissippi";
		String p = "missiiabc";
		// String s = "aaaaaaaa";
		// String p = "a*???????aa*";
		// String s = "abaab";
		// String p = "*.a.";
		System.out.println(new WildcardMatching().isMatch1(s, p));
	}
}

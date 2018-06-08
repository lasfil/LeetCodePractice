package com.cyandragon.leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note:
 * 
 * Have you consider that the string might be empty? This is a good question to
 * ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int n = s.length();
		if (n < 2)
			return true;

		int i = 0;
		int j = n - 1;

		while (i < j) {
			char a = s.charAt(i);
			char b = s.charAt(j);
			if (a == b) {
				i++;
				j--;
			} else if (a < '0' || (a > '9' && a < 'A') || (a > 'Z' && a < 'a')
					|| a > 'z')
				i++;
			else if (b < '0' || (b > '9' && b < 'A') || (b > 'Z' && b < 'a')
					|| b > 'z')
				j--;
			else if (Math.abs(a - b) != 32 && a - b != 0)
				return false;

		}

		return true;

	}
}

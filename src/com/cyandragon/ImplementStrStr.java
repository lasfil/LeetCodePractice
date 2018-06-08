package com.zinkirin;
/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 */
public class ImplementStrStr {
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return null;
		int m = haystack.length();
		int n = needle.length();
		if (n == 0)
			return haystack;

		for (int i = 0; i <= m - n; i++) {
			if (haystack.charAt(i) == needle.charAt(0)
					&& haystack.charAt(i + n - 1) == needle.charAt(n - 1)) {
				int j = 1;
				while (j < n) {
					if (haystack.charAt(i + j) == needle.charAt(j))
						j++;
					else
						break;
				}

				if (j == n)
					return haystack.substring(i);
			}
		}

		return null;

	}

	public String strStr1(String haystack, String needle) {
		if (haystack == null || needle == null || needle.length() == 0)
			return haystack;
		if (needle.length() > haystack.length())
			return null;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			boolean successFlag = true;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					successFlag = false;
					break;
				}
			}
			if (successFlag)
				return haystack.substring(i);
		}
		return null;

	}

}

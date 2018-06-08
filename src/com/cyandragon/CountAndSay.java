package com.zinkirin;
/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
	public String countAndSay(int n) {
		String result = "";
		if (n == 0)
			return result;
		result = "1";

		for (int i = 1; i < n; i++) {
			result = nextCAS(result);
		}

		return result;
	}

	public String nextCAS(String s) {
		int len = s.length();
		if (len == 0)
			return s;

		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (i < len) {
			int j = i + 1;
			while (j < len && s.charAt(j) == s.charAt(i))
				j++;

			sb.append(j - i);
			sb.append(s.charAt(i));
			i = j;
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(15));
	}
}

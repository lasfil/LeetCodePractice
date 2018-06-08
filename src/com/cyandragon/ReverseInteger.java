package com.zinkirin;
/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * Throw an exception? Good, but what if throwing an exception is not an option?
 * You would then have to re-design the function (ie, add an extra parameter).
 */
public class ReverseInteger {
	public int reverse(int x) {
		if (Math.abs(x) < 10)
			return x;
		while (x % 10 == 0)
			x = x / 10;
		if (Math.abs(x) < 10)
			return x;
		String org = String.valueOf(x);
		int len = org.length();
		char[] cs = new char[len];
		if (x < 0)
			cs[0] = org.charAt(0);

		for (int i = 0; i < len; i++) {
			if (x > 0)
				cs[i] = org.charAt(len - 1 - i);
			else if (i > 0)
				cs[i] = org.charAt(len - i);
		}

		return Integer.valueOf(new String(cs));
	}

	// public int reverse(int x) {
	// int num = Math.abs(x);
	// int ret = 0;
	// while (num != 0) {
	// int d = num - num / 10 * 10;
	// ret = ret * 10 + d;
	// num /= 10;
	// }
	// if (x < 0)
	// return -ret;
	// else
	// return ret;
	// }

	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(-123231554));
	}
}

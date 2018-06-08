package com.cyandragon.leetcode;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == divisor)
			return 1;
		if (dividend == 0 || divisor == Integer.MIN_VALUE)
			return 0;
		if (divisor == 0) {
			if (dividend > 0)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}

		if (divisor == 1) {
			return dividend;
		}

		if (divisor == -1) {
			return (int) (0 - (long) dividend);
		}

		if (divisor == Integer.MAX_VALUE) {
			if (dividend <= -Integer.MAX_VALUE)
				return -1;
			else
				return 0;
		}

		boolean neg = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));
		long dividendl = (long) dividend;
		long divisorl = (long) divisor;

		dividendl = Math.abs(dividendl);
		divisorl = Math.abs(divisorl);
		if (dividendl == divisorl)
			return -1;
		if (dividendl < divisorl)
			return 0;

		StringBuffer sbret = new StringBuffer();
		StringBuffer temp = new StringBuffer();

		StringBuffer sb = new StringBuffer(String.valueOf(dividendl));
		long remain = 0;
		for (int i = 0; i < sb.length(); i++) {
			temp.setLength(0);

			temp.append(remain).append(Character.digit(sb.charAt(i), 10));
			long digDividend = Long.valueOf(temp.toString());
			int count = 0;
			while (digDividend >= divisorl) {
				digDividend -= divisorl;
				count++;
			}
			remain = digDividend;
			sbret.append(count);
		}

		int result = Integer.valueOf(sbret.toString());
		if (neg)
			result = 0 - result;
		return result;
	}

	public int divide1(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		BigDecimal d0 = new BigDecimal(dividend);
		d0 = d0.abs();
		BigDecimal d1;
		BigDecimal d3 = new BigDecimal(divisor);
		d3 = d3.abs();
		int count = 0;
		boolean start = true;
		while (d0.compareTo(d3) == 1 || d0.compareTo(d3) == 0) {
			d1 = new BigDecimal(divisor);
			d1 = d1.abs();
			start = true;
			while (d0.compareTo(d1) == 1 || d0.compareTo(d1) == 0) {
				if (start) {
					list.add(1);
					start = false;
				} else {
					int last = list.get(list.size() - 1);
					list.add(last + last);
				}
				d0 = d0.subtract(d1);
				d1 = d1.add(d1);
			}
		}

		for (int e : list) {
			count += e;
		}

		return (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? count
				: -count;
	}

	public static void main(String[] args) {
		int a = -2147483648;
		int b = -1017100424;
		System.out.print((a / b) == new DivideTwoIntegers().divide(a, b));
	}

}

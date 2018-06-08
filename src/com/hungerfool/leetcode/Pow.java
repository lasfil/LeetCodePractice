package com.hungerfool.leetcode;

import org.junit.Test;

public class Pow {
	@Test
	public void test() {
		new Pow().myPow(2, 7);
	}

	public double myPow(double x, int n) {
		long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		double res = 1;
		while (N > 0) {
			if (N % 2 == 1) {
				res = res * x;
			}
			N = N / 2;
			x = x * x;
		}
		return res;
	}
}

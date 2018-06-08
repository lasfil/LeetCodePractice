package com.cyandragon;
/**
 * Implement pow(x, n)
 */
public class Pow {
	public double pow(double x, int n) {
		if (x == 0.0)
			return x;
		if (n >= 0)
			return powabs(x, (long) n);
		else
			return 1 / powabs(x, -(long) n);
	}

	public double powabs(double x, long n) {
		if (x == 0.0)
			return 0.0;
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n == 2)
			return x * x;
		long half = n / 2;
		long remain = n % 2;
		return powabs(powabs(x, half), 2) * (remain == 0 ? 1 : x);
	}

	public static void main(String[] args) {
		System.out.println(new Pow().pow(8.66731, 4));
	}
}

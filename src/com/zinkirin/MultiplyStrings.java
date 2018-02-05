package com.zinkirin;
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null)
			return null;
		if (num1.length() == 0 || num2.length() == 0 || num1.equals("0")
				|| num2.equals("0"))
			return "0";

		char[] nc1 = num1.toCharArray();
		char[] nc2 = num2.toCharArray();
		int m = nc1.length;
		int n = nc2.length;

		int[][] mul = new int[n + 1][m + n];
		int add = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				int digMul = Character.digit(nc1[j], 10)
						* Character.digit(nc2[i], 10) + add;
				add = digMul / 10;
				mul[i][i + j + 1] = digMul - add * 10;
			}
			mul[i][i] = add;
			add = 0;
		}

		for (int j = m + n - 1; j >= 0; j--) {
			int sum = add;
			for (int i = 0; i < n; i++) {
				sum += mul[i][j];
			}
			add = sum / 10;
			mul[n][j] = sum - add * 10;
		}
		StringBuffer sb = new StringBuffer();
		if (add > 0)
			sb.append(add);

		for (int j = 0; j < m + n; j++)
			sb.append(mul[n][j]);
		// 去除开头多余的0
		int s = 0;
		while (sb.charAt(s) == '0')
			s++;
		return sb.substring(s);

	}

	public static void main(String[] args) {
		new MultiplyStrings().multiply("1", "1");
	}
}

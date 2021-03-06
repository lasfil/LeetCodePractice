package com.cyandragon.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null)
			return result;
		int len = s.length();
		if (len < 4 || len > 12)
			return result;
		String first = null;
		String second = null;
		String third = null;
		String forth = null;

		for (int i = 1; i <= 3; i++) {
			// 如果i后不足3位直接跳出
			if (len - i < 3)
				break;
			first = s.substring(0, i);
			if (first.matches("^0\\d+") || Integer.valueOf(first) > 255)
				continue;

			for (int j = i + 1; j <= 6; j++) {
				// 如果j后不足两位直接跳出
				if (len - j < 2)
					break;

				second = s.substring(i, j);
				if (second.matches("^0\\d+") || Integer.valueOf(second) > 255)
					continue;

				for (int k = j + 1; k <= 9; k++) {
					// 如果k后不足一位直接跳出
					if (k >= len) {
						break;
					}
					// 如果k后大于3位直接跳过
					if (len - k > 3)
						continue;
					third = s.substring(j, k);
					if (third.matches("^0\\d+") || Integer.valueOf(third) > 255)
						continue;

					forth = s.substring(k, len);
					if (!forth.matches("^0\\d+")
							&& Integer.valueOf(forth) <= 255) {
						// 走到这里证明四段子串都合法，可以组成ip地址
						result.add(first + "." + second + "." + third + "."
								+ forth);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new RestoreIPAddress().restoreIpAddresses("010010"));
	}
}

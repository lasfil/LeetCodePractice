package com.cyandragon;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {
	public int romanToInt(String s) {
		Map<String, Integer> dic = new HashMap<String, Integer>() {
			{
				put("I", 1);
				put("V", 5);
				put("X", 10);
				put("L", 50);
				put("C", 100);
				put("D", 500);
				put("M", 1000);
				put("IV", 4);
				put("IX", 9);
				put("XL", 40);
				put("XC", 90);
				put("CD", 400);
				put("CM", 900);
			}
		};

		int i = 0;
		int sum = 0;
		while (i < s.length()) {
			if (i < s.length() - 1 && dic.containsKey(s.substring(i, i + 2))) {
				sum += dic.get(s.substring(i, i + 2));
				i += 2;
			} else {
				sum += dic.get(s.substring(i, i + 1));
				i++;
			}
		}

		return sum;

	}
}

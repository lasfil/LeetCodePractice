package com.cyandragon.leetcode;

import java.util.Base64;

import org.junit.Test;

public class ShortURL {
	@Test
	public void test() {
		String base64String = "whuang123";

		System.out.println(Base64.getEncoder().encodeToString(base64String.getBytes()));
		encode(43L);
	}

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
	public static final int BASE = ALPHABET.length();

	public static String encode(long num) {
		StringBuilder str = new StringBuilder();
		while (str.length() < 6) {
			str.insert(0, ALPHABET.charAt((int) (num % BASE)));
			num = num / BASE;
		}
		return str.toString();
	}

	public static Long decode(String str) {
		Long num = 0L;
		for (int i = 0; i < str.length(); i++) {
			num = num * BASE + ALPHABET.indexOf(str.charAt(i));
		}
		return num;
	}
}

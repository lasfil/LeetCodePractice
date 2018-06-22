package com.cyandragon.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindIPAddress {
	public static void main(String[] args) {
		String input = generateInput(10000);
		System.out.println(input);
	
	}



	public static String generateInput(int volume) {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < volume; i++) {
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}

	public static List<List<Integer>> findIPAddress(String input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int left = 0; left < input.length() - 4; left++) {
			int right = left + 1;
			int current = left;
			while (right < input.length() && right - left > 4 && right - left < 9) {

			}
		}

		return result;
	}
}

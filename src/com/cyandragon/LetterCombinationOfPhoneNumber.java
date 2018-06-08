package com.cyandragon;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
	private char[][] codex = new char[][] { { ' ' }, { ' ' },
			{ 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' },
			{ 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations(String digits) {
		int n = digits.length();
		List<String> result = new ArrayList<String>();
		result.add("");
		if (n == 0) {
			return result;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			char c = digits.charAt(i);
			if (c < '2' || c > '9')
				return null;
			int num = Character.digit(c, 10);
			char[] code = codex[num];
			List<String> tmp = new ArrayList<String>();
			for (String s : result) {
				for (char l : code) {
					sb.append(s);
					sb.append(l);
					tmp.add(sb.toString());
					sb.setLength(0);
				}
			}
			result = tmp;
		}
		return result;
	}
}

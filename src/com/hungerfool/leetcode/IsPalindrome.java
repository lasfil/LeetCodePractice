package com.hungerfool.leetcode;

import org.junit.Test;

public class IsPalindrome {
	@Test
	public void test() {
		new IsPalindrome().isPalindrome(10);
	}

	public boolean isPalindrome(int x) {
		if (x < 10 && x >=0) {
			return true;
		}
		if (x < 0 || x % 10 == 0) {
			return false;
		}
		
		int left = x;
		int right = 0;
		while (left > right) {
			right = right * 10 + left % 10;
			left = left / 10;
		}
		
		if (left == right || right / 10 == left) {
			return true;
		}
		return false;
	}
}

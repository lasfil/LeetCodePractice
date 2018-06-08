package com.cyandragon.leetcode;
import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 */
public class LongestValidParenthese {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2)
			return 0;
		StringBuffer sb = new StringBuffer(s);

		while (sb.length() > 0 && sb.charAt(0) == ')')
			sb.deleteCharAt(0);

		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '(')
			sb.deleteCharAt(sb.length() - 1);
		boolean[] excp = new boolean[sb.length()];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c == '(')
				stack.push(i);
			else if (c == ')') {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					excp[i] = true;
				}

			}
		}

		while (!stack.isEmpty())
			excp[stack.pop()] = true;

		int count = 0;
		int i = 0;
		int max = 0;
		while (i < excp.length) {
			if (excp[i++]) {
				max = Math.max(max, count);
				count = 0;
			} else {
				count++;
			}
		}

		return Math.max(max, count);
	}

	public static void main(String[] args) {
		System.out.println(new LongestValidParenthese()
				.longestValidParentheses("(()"));
	}
}

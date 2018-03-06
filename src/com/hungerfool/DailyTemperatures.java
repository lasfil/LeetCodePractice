package com.hungerfool;

import java.util.Stack;
// Stack里自顶向下按升序存index，每次比较新的index能比stack里大的都弹出
public class DailyTemperatures {
	public static void dailyTemperatures() {
		int[] temp = new int[] { 10, 8, 9, 7, 5, 3, 4, 9 };
		System.out.println(dailyTemperatures(temp));
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				temperatures[stack.peek()] = i - stack.pop();
			}

			stack.push(i);
		}
		while (!stack.isEmpty()) {
			temperatures[stack.pop()] = 0;
		}
		return temperatures;
	}
}

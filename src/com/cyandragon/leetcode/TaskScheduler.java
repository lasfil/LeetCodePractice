package com.cyandragon.leetcode;

import java.util.Arrays;

public class TaskScheduler {
	public static void main(String[] args) {
		//leastInterval(new char[] { 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 'C' }, 2);
		leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 50);
	}

	public static int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c : tasks)
			map[c - 'A']++;
		Arrays.sort(map);
		int max_val = map[25] - 1, idle_slots = max_val * n;
		for (int i = 24; i >= 0 && map[i] > 0; i--) {
			idle_slots -= Math.min(map[i], max_val);
		}
		return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
	}
	
	
}

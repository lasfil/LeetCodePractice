package com.hungerfool;

public class ReconstructQueue {
	public static void reconstructQueue() {
		int[][] people = new int[][] { { 3, 5 }, { 2, 2 }, { 3, 1 }, { 3, 4 }, { 4, 2 }, { 4, 1 }, { 7, 0 } };
		System.out.println(reconstructQueue(people));
	}

	public static int[][] reconstructQueue(int[][] people) {
		for (int i = 1; i < people.length; i++) {
			sortArray(people, i);
		}
		for (int i = 1; i < people.length; i++) {
			int pos = i;
			while (pos != people[pos][1] && pos > 0) {
				int temp = people[pos][0];
				people[pos][0] = people[pos - 1][0];
				people[pos - 1][0] = temp;
				temp = people[pos][1];
				people[pos][1] = people[pos - 1][1];
				people[pos - 1][1] = temp;
				pos--;
			}
		}

		return people;
	}

	private static void sortArray(int[][] array, int right) {
		if (right <= 0 || right >= array.length) {
			return;
		}
		int left = right - 1;
		int temp = 0;
		while (left >= 0) {
			if (rowsComapreTo(array, left, right) < 0) {
				temp = array[left][0];
				array[left][0] = array[right][0];
				array[right][0] = temp;
				temp = array[left][1];
				array[left][1] = array[right][1];
				array[right][1] = temp;
				right = left;
				left = right - 1;
			} else {
				break;
			}

		}

	}

	private static int rowsComapreTo(int[][] array, int left, int right) {
		if (array[left][0] > array[right][0]) {
			return 1;
		}

		if (array[left][0] < array[right][0]) {
			return -1;
		}

		return array[right][1] - array[left][1];
	}
}

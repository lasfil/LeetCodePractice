package com.cyandragon.leetcode;

import org.junit.Test;

public class HIndex {
	@Test
	public void test() {
		System.out.println(new HIndex().hIndex(new int[] { 1, 0 }));
		System.out.println(new HIndex().hIndex1(new int[] { 6, 5, 2, 1, 0, 0, 7 }));
	}

	public int hIndex1(int[] citations) {
		int length = citations.length;
		if (length == 0) {
			return 0;
		}

		int[] array2 = new int[length + 1];
		for (int i = 0; i < length; i++) {
			if (citations[i] > length) {
				array2[length] += 1;
			} else {
				array2[citations[i]] += 1;
			}
		}
		int t = 0;

		for (int i = length; i >= 0; i--) {
			t = t + array2[i];
			if (t >= i) {
				return i;
			}
		}
		return 0;
	}

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}

		return quickIndex(citations, 0, citations.length - 1);
	}

	private int quickIndex(int[] citations, int start, int end) {
		if (end < start) {
			return 0;
		}
		if (start == end) {
			if (isHIndex(citations, start)) {
				return start + 1;
			} else {
				return 0;
			}
		}
		if (end - start == 1) {

			if (citations[start] < citations[end]) {
				swap(citations, start, end);
			}

			if (isHIndex(citations, start)) {
				return start + 1;
			}

			if (isHIndex(citations, end)) {
				return end + 1;
			}
			return 0;
		}

		int pivot = start;
		int h = start + 1;
		int l = end;
		while (h <= l) {
			if (citations[h] >= citations[pivot]) {
				h++;
			} else if (citations[l] < citations[pivot]) {
				l--;
			} else {
				swap(citations, h, l);
				h++;
				l--;
			}
		}
		swap(citations, l, pivot);
		if (l < end) {
			int index = quickIndex(citations, l + 1, end);
			if (index > 0) {
				return index;
			}
		}
		if (isHIndex(citations, l)) {
			return l + 1;
		}

		return quickIndex(citations, start, l - 1);

	}

	private void swap(int[] citations, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = citations[i];
		citations[i] = citations[j];
		citations[j] = temp;
	}

	private boolean isHIndex(int[] citations, int i) {
		if (i >= citations.length) {
			return false;
		}
		if (citations[i] >= i + 1 && citations.length - i - 1 <= citations[i]) {
			return true;
		}
		return false;
	}
}

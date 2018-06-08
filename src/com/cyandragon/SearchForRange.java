package com.cyandragon;
public class SearchForRange {
	public int[] searchRange(int[] A, int target) {
		int len = A.length;
		if (len == 0 || target < A[0] || target > A[len - 1])
			return new int[] { -1, -1 };
		int h = len - 1;
		int l = 0;
		int mid = (h - l) / 2 + l;
		int i = -1;
		int j = -1;
		while (l <= h) {
			if (target == A[mid]) {
				break;
			} else {

				if (target > A[mid]) {
					l = mid + 1;
				} else if (target < A[mid]) {
					h = mid - 1;
				}
			}
			if (h < l)
				return new int[] { i, j };
			mid = (h - l) / 2 + l;
		}

		i = mid;
		j = mid;
		while (i > 0 && A[i - 1] == target)
			i--;
		while (j < len - 1 && A[j + 1] == target)
			j++;
		return new int[] { i, j };

	}

	public static void main(String[] args) {
		System.out.println(new SearchForRange().searchRange(new int[] { 0, 2,
				2, 3, 4, 4, 4 }, 1)[0]);
	}
}

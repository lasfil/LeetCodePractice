package com.cyandragon;
/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 */
public class FindMinimumInRotatedArray2 {
	public int findMin(int[] num) {
		if (num == null || num.length == 0)
			return Integer.MIN_VALUE;
		if (num.length == 1)
			return num[0];
		int l = 0;
		int h = num.length - 1;

		while (l < h) {
			while (l < num.length - 1 && num[l + 1] == num[l]) {
				l++;
			}
			if (l == num.length - 1)
				return num[l];
			while (num[h] == num[l] || num[h - 1] == num[h])
				h--;

			if (num[l] < num[h])
				return num[l];

			int mid = (h + l) / 2;

			if (mid == l)
				return Math.min(num[l], num[h]);

			if (num[mid - 1] > num[mid] && num[mid + 1] >= num[mid]) {
				return num[mid];
			}

			if (num[mid - 1] <= num[mid] && num[mid + 1] < num[mid]) {
				return num[mid + 1];
			}
			if (num[mid] < num[l]) {
				h = mid;
			} else if (num[mid] > num[l]) {
				l = mid;
			}
		}

		return num[l];
	}

	public static void main(String[] args) {
		new FindMinimumInRotatedArray2().findMin(new int[] { 3, 4, 4, 4, 4, 4,
				4, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8,
				8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, -10, -10, -10, -9,
				-8, -8, -8, -8, -8, -7, -7, -7, -7, -6, -6, -6, -6, -6, -6, -6,
				-5, -5, -5, -4, -4, -4, -4, -3, -3, -3, -3, -3, -3, -2, -2, -2,
				-2, -1, -1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2,
				3, 3, 3 });
	}
}

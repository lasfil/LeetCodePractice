package com.zinkirin;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 */
public class MedianOfTwoSortedArray {
	public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		if (len == 0)
			return 0.0;
		int count = len / 2;

		int i = 0;
		int j = 0;
		int mid = 0;
		int pre = 0;
		while (count >= 0) {
			if (j >= B.length) {
				mid = A[i];
				i++;
			} else if (i >= A.length) {
				mid = B[j];
				j++;
			} else if (A[i] < B[j]) {
				mid = A[i];
				i++;
			} else {
				mid = B[j];
				j++;
			}
			if (count == 1)
				pre = mid;
			count--;
		}

		if (len % 2 == 0)
			return ((double) mid + (double) pre) / 2;
		else
			return (double) mid;
	}

	public double findMedianSortedArrays1(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int len = m + n;
		if (len % 2 != 0) {
			return findKth(A, 0, B, 0, len / 2 + 1);
		} else {
			return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
		}
	}

	private double findKth(int A[], int a, int B[], int b, int k) {
		if (A.length - a > B.length - b) {
			return findKth(B, b, A, a, k);
		}
		if (a >= A.length) {
			return B[b + k - 1];
		}
		if (k == 1) {
			return Math.min(A[a], B[b]);
		}
		if (k == 2) {
			return Math.max(A[a], B[b]);
		}
		int midA = Math.min(k / 2, A.length - a);
		int midB = k - midA;
		if (A[a + midA - 1] < B[b + midB - 1]) {
			return findKth(A, a + midA, B, b, k - midA);
		} else if (A[a + midA - 1] > B[b + midB - 1]) {
			return findKth(A, a, B, b + midB, k - midB);
		} else {
			return A[a + midA - 1];
		}
	}
	

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 4, 6, 8, 9, 13, 14, 16, 17, 19 };
		int[] B = new int[] { 3, 3, 4};
		System.out.println(new MedianOfTwoSortedArray().findMedianSortedArrays1(
				A, B));
	}
}

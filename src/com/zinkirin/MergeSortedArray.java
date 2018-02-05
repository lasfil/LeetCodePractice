package com.zinkirin;
/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: 
 * 
 * You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int i = m - 1;
		int j = n - 1;
		for (int cur = i + n; cur >= 0; cur--) {
			if (j >= 0) {
				if (i < 0) {
					A[cur] = B[j];
					j--;
				} else {
					if (A[i] > B[j]) {
						A[cur] = A[i];
						i--;
					} else {
						A[cur] = B[j];
						j--;
					}
				}
			}
		}
	}
	
	public void merge1(int A[], int m, int B[], int n) {
		int i = m - 1, j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			A[k--] = A[i] >= B[j] ? A[i--] : B[j--];
		}
		while (j >= 0) {
			A[k--] = B[j--];
		}
	}

	public static void main(String[] args) {
		int[] A = new int[]{};
		int[] B = new int[]{1};
		
		new MergeSortedArray().merge(A, 0, B, 1);
	}
}

package com.hungerfool.leetcode;

import org.junit.Test;

public class RepeatedSubarray {
	@Test
	public void test() {
		int[] a = { 1, 2, 3, 2, 1 };
		int[] b = { 1, 2, 3, 4, 7 };
		System.out.println(findLength(a, b));
	}

	public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        int result = 0;
        int[][] arr = new int[100][2];
        for (int i = 0; i < A.length; i++) {
            arr[A[i]][0]++;
        }
        
        for (int i = 0; i < B.length; i++) {
            arr[B[i]][1]++;
           
        }
        for (int i = 0; i < 100; i++) {
            result += Math.min(arr[i][0], arr[i][1]);
        }
        return result;
	}
}

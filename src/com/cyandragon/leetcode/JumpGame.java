package com.cyandragon.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	public boolean canJump(int[] A) {

		if (A.length < 2)
			return true;

		boolean result = nextHop(A, 0);
		return result;
	}

	public boolean nextHop(int[] A, int index) {
		if (index >= A.length - 1)
			return true;
		int i = A[index];
		if (i == 0 && index < A.length - 1)
			return false;
		while (i > 0) {
			if (nextHop(A, index + i))
				return true;

			i--;

		}

		return false;
	}

	public boolean canJump1(int[] A) {
		if (A.length <= 1)
			return true;
		int curMax = 0;
		int max = 0;
		
		for (int i = 0; i < A.length - 1; i++) {
			// 如果当前节点比max大证明从原点出发都无法走到当前节点
			if (i > max)
				break;
			// curMax表示从当前节点出发最远处的index
			curMax = A[i] + i;
			// max表示从原点出发能走到的最远的index
			// 如果curMax > max表示从原点经过当前节点能到达更远的位置，所以更新max
			if (curMax > max) {
				max = curMax;
			}
			// 如果max超过了终点证明能走到终点
			if (max >= A.length - 1)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8,
				0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0,
				0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6,
				5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1,
				9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5,
				1, 7, 9, 6, 3, 2, 2, 0, 0 };
		System.out.println(new JumpGame().canJump1(a));
	}
}

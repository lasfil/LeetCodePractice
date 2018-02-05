package com.zinkirin;
import java.util.Arrays;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * 
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 */

public class JumpGame2 {
	// 这个方法在到不了终点的时候无效
	public int jump(int[] A) {
		int ret = 0;
		int last = 0;
		int curr = 0;
		for (int i = 0; i < A.length; ++i) {
			if (i > last) {
				last = curr;
				++ret;
			}
			curr = Math.max(curr, i + A[i]);
		}
		return ret;
	}

	public int jump2(int[] A) {
		if (A.length <= 1)
			return 0;
		int curMax = 0;
		int max = 0;
		int[] minJump = new int[A.length];
		Arrays.fill(minJump, Integer.MAX_VALUE);
		minJump[0] = 0;
		for (int i = 0; i < A.length - 1; i++) {

			// 如果当前节点比max大证明从原点出发都无法走到当前节点
			if (i > max)
				return 0;
			// curMax表示从当前节点出发最远处的index
			curMax = A[i] + i;
			// max表示从原点出发能走到的最远的index
			// 如果curMax > max表示从原点经过当前节点能到达更远的位置，所以更新max
			if (curMax > max) {
				max = curMax;
				for (int j = i + 1; j <= Math.min(max, A.length - 1); j++) {
					minJump[j] = Math.min(minJump[j], minJump[i] + 1);
				}

			}
			// 如果max超过了终点证明能走到终点
			if (max >= A.length - 1)
				return minJump[i] + 1;
		}
		return minJump[A.length - 1];
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8,
				0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0,
				0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6,
				5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(new JumpGame().canJump(a));
		System.out.println(new JumpGame2().jump2(a));
	}
}

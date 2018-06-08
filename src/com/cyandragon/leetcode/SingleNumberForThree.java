package com.cyandragon.leetcode;
import java.util.Arrays;

/*Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
public class SingleNumberForThree {
	public int singleNumber(int[] A) {

		int single = A[0];
		Arrays.sort(A);
		for (int i = 0; i < A.length; i += 3) {
			if (i == A.length - 1 || A[i] != A[i + 1]) {
				single = A[i];
				break;
			}
		}
		return single;
	}

	public int singleNumber2(int[] A) {
		int ones = 0, twos = 0, xthrees = 0;
		for (int i = 0; i < A.length; ++i) {
			twos |= (ones & A[i]);
			ones ^= A[i];
			xthrees = ~(ones & twos);
			ones &= xthrees;
			twos &= xthrees;
		}
		return ones;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 101, 342, 389, 144, 755, 126, 101, 342, 389, 144,
				755, 126, 88, 8, 9, 8, 9, 101, 342, 389, 144, 755, 126, 8, 9 };
		SingleNumberForThree sn = new SingleNumberForThree();
		// System.out.println(sn.singleNumber(A));
		System.out.println(sn.singleNumber2(A));
	}
}

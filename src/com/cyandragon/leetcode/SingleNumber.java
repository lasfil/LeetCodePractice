package com.cyandragon.leetcode;
import java.util.Arrays;

/*Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
public class SingleNumber {
	public int singleNumber(int[] A) {

		int single = A[0];
		Arrays.sort(A);
		for (int i = 0; i < A.length; i += 2) {
			if (i == A.length - 1 || A[i] != A[i + 1]) {
				single = A[i];
				break;
			}
		}
		return single;
	}

	public int singleNumber2(int[] A) {
		int ret = A[0];

		for (int i = 1; i < A.length; i++) {
			// 不管隔多远，只要相同的数字XOR两次就会抵消为0，所以最后是0^single，最后还是single
			ret = ret ^ A[i];
		}

		return ret;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 101, 342, 389, 144, 755, 126, 101, 342, 389, 144,
				755, 126, 88, 8, 9, 8, 9 };
		SingleNumber sn = new SingleNumber();
		// System.out.println(sn.singleNumber(A));
		System.out.println(sn.singleNumber2(A));
	}
}

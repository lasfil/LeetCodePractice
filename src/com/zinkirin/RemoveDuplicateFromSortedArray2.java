package com.zinkirin;
/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example,
 * 
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3, *].
 *
 */
public class RemoveDuplicateFromSortedArray2 {
	public int removeDuplicates(int[] A) {
		if (A.length < 2)
			return A.length;

		int last = 0;
		int i = 0;

		while (i < A.length) {
			// 跟last前一个比，如果相同说明是3个以上的重复，如果不同说明是第一个重复或者不同
			if (A[i] != A[last - 1]) {
				last++;
				A[last] = A[i];
			}
			i++;
		}

		return ++last;
	}
}

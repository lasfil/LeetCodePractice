package com.zinkirin;
/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2, *].
 */
public class RemoveDuplicateFromSortedArray {
	public int removeDuplicates(int[] A) {
        if (A.length < 2)
            return A.length;
        
        int last = 0;
        int i = 0;
        
        while (i < A.length) {
            if (A[i] != A[last]) {
                last++;
                A[last] = A[i];
            }
            i++;
        }
        
        return ++last;
    }
}

package com.cyandragon;
/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        if (A.length == 0)
            return 0;
        int count = A.length - 1;
       
        for (int i = count; i >= 0; i--) {
            if (A[i] == elem) {
                if (count != i) {
                    int tmp = A[i];
                    A[i] = A[count];
                    A[count] = tmp;
                }
                count--;
            }
        }
        return count + 1;
    }
	public int removeElement2(int[] A, int elem) {
		if (A.length == 0)
			return 0;
		else {
			int p = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] != elem) {
					A[p++] = A[i];
				}
			}
			return p;
		}
	}
	public static void main(String[] args) {
		int[] a = new int[]{4, 5};
		new RemoveElement().removeElement(a, 4);
		System.out.println(a);
	}
	
}

package com.cyandragon;
/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. 
 * 
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num.length < 2)
			return;
	    if (num[num.length - 2] < num[num.length - 1]) {
			swap(num, num.length - 2, num.length - 1);
			return;
		}
		int i = num.length - 2;
		while (i > 0) {
			if (num[i] <= num[i - 1])
				i--;
			else
				break;
		}
		
		sortAsc(num, i);
		rightPosition(num, i - 1);
	}

	private void sortAsc(int[] num, int s) {
		int i = s;
		int j = num.length - 1;
		while (i < j)
			swap(num, i++, j--);
	}

	private void rightPosition(int[] num, int index) {
		if (index == num.length - 1 || index < 0)
			return;
		
		for (int i = index + 1; i < num.length; i++) {
			if (num[i] > num[index])
			swap(num, i, index);
		}
	}

	private void swap(int[] num, int i, int j) {
		if (i < 0 || j < 0 || i > num.length || j > num.length)
			return;
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
}

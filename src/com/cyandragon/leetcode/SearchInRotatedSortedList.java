package com.cyandragon.leetcode;
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedList {
	public int search(int[] A, int target) {
		if (A.length == 0)
			return -1;

		return search(A, target, 0, A.length - 1);
	}

	public int search(int[] A, int target, int start, int end) {
		if (start == -1 || end == -1 || start > end)
			return -1;

		if (start == end) {
			if (A[start] == target)
				return start;
			else
				return -1;
		}
		if (A[start] == target)
			return start;
		if (A[end] == target)
			return end;

		int mid = start + (end - start) / 2;
		if (A[mid] == target)
			return mid;
		if (A[end] > A[start]) {
			if (target > A[end] || target < A[start])
				return -1;
			else {
				if (target > A[mid])
					return search(A, target, mid + 1, end);
				else
					return search(A, target, start, mid - 1);
			}
		}

		int result = -1;

		if (A[mid] > A[start]) {
			if (target > A[start] && target < A[mid])
				result = search(A, target, start, mid - 1);
			else
				result = search(A, target, mid + 1, end);
				
		} else {
			if (target > A[mid] && target < A[end])
				result = search(A, target, mid + 1, end);
			else
				result = search(A, target, start, mid - 1);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 7,8,9,0,1,3,4,5 };
		System.out.println(new SearchInRotatedSortedList().search(a, 4));
	}
}

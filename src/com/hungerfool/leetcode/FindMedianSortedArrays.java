package com.hungerfool.leetcode;

import com.hungerfool.leetcode.util.ListNode;

public class FindMedianSortedArrays {
	public static void main(String[] args) {
		findMedianSortedArrays(new int[] {2, 5},new int[0]);
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int total = nums1.length + nums2.length;
		int mid = total / 2;
		int n1 = 0;
		int n2 = 0;
		double result = 0.0d;

		for (int i = 0; i <= mid; i++) {
			if (n1 >= nums1.length) {
				result = nums2[n2++];
			} else if (n2 >= nums2.length) {
				result = nums1[n1++];
			} else {
				if (nums1[n1] < nums2[n2])
					result = nums1[n1++];
				else
					result = nums2[n2++];
			}
		}

		if (total % 2 == 0) {
			double next = 0.0d;
			if (n1 >= nums1.length) {
				next = nums2[n2++];
			} else if (n2 >= nums2.length) {
				next = nums1[n1++];
			} else {
				if (nums1[n1] < nums2[n2])
					next = nums1[n1++];
				else
					next = nums2[n2++];
			}
			result = (result + next) / 2;
		}

		return result;
	}
}

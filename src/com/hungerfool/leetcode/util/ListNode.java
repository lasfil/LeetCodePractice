package com.hungerfool.leetcode.util;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public static ListNode create(int[] arr) {
		if (arr.length == 0) {
			return null;
		}
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
		for (int i = 1; i < arr.length; i++) {
			current.next = new ListNode(arr[i]);
			current = current.next;
		}
		return head;
	}
}

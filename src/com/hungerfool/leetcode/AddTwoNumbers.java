package com.hungerfool.leetcode;

import com.hungerfool.leetcode.util.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers.
 * 
 * The digits are stored in reverse order and each of their nodes contain a
 * single digit.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = ListNode.create(new int[] { 2, 4, 3 });
		ListNode l2 = ListNode.create(new int[] { 5, 6, 4 });

		System.out.println(addTwoNumbers1(l1, l2));
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode c1 = l1;
		ListNode c2 = l2;
		ListNode head = new ListNode(0);
		ListNode tail = head;

		int add = 0;
		// 一直相加到l1,l2都为空
		while (c1 != null || c2 != null) {
			int sum = ((c1 == null) ? 0 : c1.val) + ((c2 == null) ? 0 : c2.val) + add;
			ListNode node = new ListNode(sum % 10);
			tail.next = node;
			tail = tail.next;
			add = sum / 10;
			c1 = (c1 == null) ? null : c1.next;
			c2 = (c2 == null) ? null : c2.next;
		}
		if (add == 1)
			tail.next = new ListNode(1);
		return head.next;

	}

	public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}
		int sum = l1.val + l2.val;
		ListNode head = new ListNode(sum % 10);
		ListNode c = head;
		int add = sum > 9 ? 1 : 0;
		ListNode c1 = l1.next;
		ListNode c2 = l2.next;
		while (add > 0 || c1 != null || c2 != null) {
			sum = (c1 == null ? 0 : c1.val) + (c2 == null ? 0 : c2.val) + add;
			add = sum > 9 ? 1 : 0;
			c.next = new ListNode(sum % 10);
			c = c.next;
			c1 = c1 == null ? null : c1.next;
			c2 = c2 == null ? null : c2.next;
		}
		c = c.next;
		return head;
	}
}

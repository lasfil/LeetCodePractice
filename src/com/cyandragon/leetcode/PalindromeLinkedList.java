package com.cyandragon.leetcode;

import org.junit.Test;

public class PalindromeLinkedList {
	@Test
	public void test() {
		ListNode head = new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(1)))))));
		isPalindrome(head);
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		if (head.val == head.next.val && head.next.next == null)
			return true;
		ListNode slow = head;
		ListNode cur = head.next;
		while (cur.next != null) {
			if (slow.val == cur.next.val) {
				if (cur.next.next != null)
					return false;
				cur.next = null;
				slow = slow.next;
				cur = slow.next;
				if (cur == null || slow.val == cur.val)
					return true;
			} else {
				cur = cur.next;
			}
		}
		return false;
	}
}

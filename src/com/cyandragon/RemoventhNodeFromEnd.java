package com.cyandragon;
/** 
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */

public class RemoventhNodeFromEnd {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0)
			return head;
		ListNode front = new ListNode(0);
		front.next = head;
		ListNode fast = front;

		int i = 0;
		while (i++ < n && fast != null)
			fast = fast.next;

		if (fast == null) {
			return head;
		}
		ListNode slow = front;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return front.next;

	}
}

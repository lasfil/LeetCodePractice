package com.cyandragon.leetcode;
/** 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicateFromLinkedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head;
		if (cur.next != null && cur.next.val != cur.val)
			cur = cur.next;
		while (cur.next != null && cur.next.val == cur.val) {
			cur.next = cur.next.next;
			if (cur.next != null && cur.next.val != cur.val)
				cur = cur.next;
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		
		new RemoveDuplicateFromLinkedList().deleteDuplicates(head);
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}

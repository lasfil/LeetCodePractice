package com.zinkirin;
/** 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * 
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 0 || k == 1)
			return head;
		ListNode front = new ListNode(0);
		front.next = head;

		ListNode fast = front;
		ListNode slow = null;
		ListNode start = front;
		ListNode tmp = null;
		while (fast != null) {
			slow = start.next;
			int step = k;
			while (step-- > 0 && fast != null) {
				fast = fast.next;
			}

			if (fast != null) {
				while (start.next != fast) {
					tmp = start.next;
					start.next = tmp.next;
					tmp.next = fast.next;
					fast.next = tmp;
				}
				start = slow;
				fast = start;
			}
		}

		head = front.next;

		return head;
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

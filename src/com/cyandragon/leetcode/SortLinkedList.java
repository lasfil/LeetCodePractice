package com.cyandragon.leetcode;

import org.junit.Test;

public class SortLinkedList {
	@Test
	public void test() {
		ListNode head = ListNode.createListNode(new int[] { -84, 142, 41, -17, -71, 170, 186, 183, -21, -76, 76, 10, 29,
				81, 112, -39, -6, -43, 58, 41, 111, 33, 69, 97, -38, 82, -44, -7, 99, 135, 42, 150, 149, -21, -30, 164,
				153, 92, 180, -61, 99, -81, 147, 109, 34, 98, 14, 178, 105, 5, 43, 46, 40, -37, 23, 16, 123, -53, 34,
				192, -73, 94, 39, 96, 115, 88, -31, -96, 106, 131, 64, 189, -91, -34, -56, -22, 105, 104, 22, -31, -43,
				90, 96, 65, -85, 184, 85, 90, 118, 152, -31, 161, 22, 104, -85, 160, 120, -31, 144, -115 });
		// ListNode head = ListNode.createListNode(new int[] { 3, 2, 1 });
		head = sortList(head);
		System.out.println(head);
	}

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode dum = new ListNode(Integer.MIN_VALUE);
		dum.next = head;

		quickSort(dum, null);

		head = dum.next;
		dum.next = null;
		dum = null;
		return head;
	}

	public void quickSort(ListNode n1, ListNode n2) {

		if (n1 == null || n1.next == null) {
			return;
		}
		ListNode end = n1;
		ListNode pivot = n1.next;
		if (pivot.next == n2 || n1.next == n2) {
			return;
		}
		ListNode curr = pivot;
		while (curr.next != n2) {
			System.out.println(curr.next.val + ":" + pivot.val);
			if (curr.next.val < pivot.val) {
				ListNode node = curr.next;
				curr.next = node.next;
				node.next = end.next;
				end.next = node;
				end = end.next;
			} else if (curr.next.val == pivot.val) {
				ListNode node = curr.next;
				curr.next = node.next;
				node.next = end.next;
				end.next = node;
			} else
				curr = curr.next;
		}
		quickSort(pivot, n2);

		quickSort(n1, end.next);
	}

	public ListNode mergetSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		ListNode n1 = mergetSortList(head);
		ListNode n2 = mergetSortList(fast);
		return merge(n1, n2);
	}

	public ListNode merge(ListNode n1, ListNode n2) {
		if (n1 == null) {
			return n2;
		}
		if (n2 == null) {
			return n1;
		}

		ListNode start;
		ListNode end;
		if (n1.val < n2.val) {
			start = n1;
			n1 = n1.next;
		} else {
			start = n2;
			n2 = n2.next;
		}
		start.next = null;
		end = start;
		while (n1 != null || n2 != null) {
			if (n1 == null) {
				end.next = n2;
				n2 = n2.next;
			} else if (n2 == null) {
				end.next = n1;
				n1 = n1.next;
			} else if (n1.val < n2.val) {
				end.next = n1;
				n1 = n1.next;
			} else {
				end.next = n2;
				n2 = n2.next;
			}
			end = end.next;
			end.next = null;
		}
		return start;
	}
}

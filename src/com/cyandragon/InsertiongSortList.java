package com.zinkirin;
/**
 * Sort a linked list using insertion sort.
 * 
 */

public class InsertiongSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode front = new ListNode(0);
		front.next = head;
		ListNode cur = head;
		ListNode minor = null;
		ListNode insert = front;

		while (cur.next != null) {
			if (cur.next.val >= cur.val)
				cur = cur.next;
			else {
				minor = cur.next;
				cur.next = minor.next;

				while (insert.next.val < minor.val)
					insert = insert.next;
				minor.next = insert.next;
				insert.next = minor;
				insert = front;
			}
		}

		return front.next;
	}
	
	public ListNode insertionSortList1(ListNode head) {
		ListNode ret = new ListNode(Integer.MIN_VALUE);
		ListNode result = ret;
		ListNode cur = new ListNode(0);
		cur.next = head;
		while (cur.next != null) {
			while (result.next != null && cur.next.val > result.next.val) {
				result = result.next;
			}
			ListNode tmp = cur.next;
			cur.next = cur.next.next;
			if (result.next == null) {
				result.next = tmp;
				tmp.next = null;
			} else {
				ListNode tmp2 = result.next;
				result.next = tmp;
				tmp.next = tmp2;
			}
			result = ret;
		}
		return result.next;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{4, 3, 2, 9, 1, 4, 8, 6, 7};
		
		ListNode[] n = new ListNode[a.length];
		n[0] = new ListNode(a[0]);
		for (int i = 1; i < a.length; i++) {
			n[i] = new ListNode(a[i]);
			n[i - 1].next = n[i];
		}
		
		new InsertiongSortList().insertionSortList1(n[0]);
	}
}

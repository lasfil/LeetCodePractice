package com.zinkirin;
public class RotateList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return val + "";
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null || n == 0)
			return head;

		ListNode front = new ListNode(0);
		front.next = head;
		ListNode fast = front;
		int i = n;
		while (i-- > 0) {
			// 考虑n大于链表长度的问题，如果fast走到头，下一步回原点
			if (fast.next == null)
				fast = head;
			else
				fast = fast.next;
		}
		if (fast == null) {
			head = front.next;
			return head;
		}
		ListNode slow = front;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		if (slow == front) {
			head = front.next;
			return head;
		}
		fast.next = front.next;
		front.next = slow.next;
		slow.next = null;
		head = front.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(new RotateList().rotateRight(head, 1));
	}
}

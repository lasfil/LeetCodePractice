package com.cyandragon.leetcode;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		/*
		 * ArrayDeque<ListNode> deque = new ArrayDeque<ListNode>();
		 * 
		 * ListNode n = null;
		 * 
		 * while (head != null) { n = head; head = n.next; n.next = null;
		 * deque.addLast(n); }
		 * 
		 * head = deque.pollFirst(); ListNode tail = deque.pollLast(); head.next = tail;
		 * 
		 * while (deque.size() > 0) { tail.next = deque.pollFirst(); tail = tail.next;
		 * tail.next = deque.pollLast(); tail = tail.next; }
		 * 
		 * tail = null; n = null;
		 */

		int size = 0;
		int i = 0;
		ListNode n = head;
		ListNode n1 = head;

		while (n != null) {
			size++;
			n = n.next;
		} // get the size of linked list

		while (i++ < (size / 2)) {
			n1 = n1.next;
		} // find the middle node of linked list

		/*
		 * while (n != null) { size++; if (size > 2 && size % 2 == 1) { n1 = n1.next; }
		 * n = n.next; }//find the middle node of linked list, n1 is the tail of first
		 * half of list
		 */
		n = n1.next;

		ListNode halfHead = null;
		while (n1.next != null) {
			n1.next = n.next;
			n.next = halfHead;
			halfHead = n;
			n = n1.next;
		} // seperate to 2 linked list and reverse the second half

		n = head;
		while (halfHead != null) {
			n1 = halfHead;
			halfHead = n1.next;
			n1.next = n.next;
			n.next = n1;
			n = n.next.next;
		} // merge 2 linked list to the expected reorder list

		n = null;
		n1 = null;
		halfHead = null;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ReorderList rlist = new ReorderList();

		ListNode head = rlist.createList(input);
		rlist.printList(head);
		rlist.reorderList(head);
		rlist.printList(head);
	}

	public ListNode createList(int[] input) {
		if (input.length == 0)
			return null;
		ListNode head = new ListNode(input[0]);

		if (input.length == 1)
			return head;
		ListNode tail = head;

		for (int i = 1; i < input.length; i++) {
			tail.next = new ListNode(input[i]);
			tail = tail.next;
		}
		return head;
	}

	public void printList(ListNode head) {
		ListNode n = head;
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}
}

class ListNode {
	public ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}

	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		next = null;
	}

	public static ListNode createListNode(int[] nums) {
		ListNode curr = new ListNode(nums[0]);
		ListNode head = curr;
		for (int i = 1; i < nums.length; i++) {
			curr.next = new ListNode(nums[i]);
			curr = curr.next;
		}
		return head;
	}

	public String toString() {
		ListNode n = next;
		StringBuilder sb = new StringBuilder().append(val).append("-");
		while (n != null) {
			sb.append(n.val).append("-");
			n = n.next;
		}
		return sb.toString();
	}
}
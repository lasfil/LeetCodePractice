package com.cyandragon;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		do {
			if (fast == null || fast.next == null || fast.next.next == null) 
				return false;
			fast = fast.next.next;
			slow = slow.next;
		} while (fast != slow);
		
		return true;
			
	}
	
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		do {
			if (fast == null || fast.next == null || fast.next.next == null)
				return null;
			fast = fast.next.next;
			slow = slow.next;
		} while (fast != slow);
		
		slow = head;
		
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode tail = head.next;
		tail.next = new ListNode(3);
		tail = tail.next;
		tail.next = new ListNode(4);
		tail = tail.next;
		tail.next = new ListNode(5);
		tail = tail.next;
		tail.next = new ListNode(6);
		tail = tail.next;
		tail.next = new ListNode(7);
		tail = tail.next;
		tail.next = head;
		System.out.println(new LinkedListCycle().hasCycle(head));
	}
}



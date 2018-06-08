package com.zinkirin;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 */
public class RemoveDuplicateFromLinkedList2 {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode front = new ListNode(0);
        front.next = head;
        
        ListNode slow = front;
        ListNode fast = front;
        
        while (slow.next != null) {
            while (fast.next != null && fast.next.val == slow.next.val) {
                fast = fast.next;
            }
            if (fast != slow.next) {
                slow.next = fast.next;
            } else 
                slow = slow.next;
        }
        
        return front.next;
    }
}

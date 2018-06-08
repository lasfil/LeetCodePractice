package com.cyandragon;
/** 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */

public class PartitionList {
	 public ListNode partition(ListNode head, int x) {
	        if (head == null || head.next == null)
	            return head;
	            
	        ListNode front = new ListNode(0);
	        front.next = head;
	        ListNode greater = new ListNode(0);
	        ListNode greaterCur = greater;
	        ListNode cur = front;
	        
	        while (cur.next != null) {
	            if (cur.next.val >= x) {
	                greaterCur.next = cur.next;
	                cur.next = cur.next.next;
	                greaterCur = greaterCur.next;
	                greaterCur.next = null;
	            } else {
	                cur = cur.next;
	            }
	        }
	        
	        cur.next = greater.next;
	        greater.next = null;
	        return front.next;
	    }
}

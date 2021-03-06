package com.cyandragon.leetcode;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        int add = 0;
        //一直相加到l1,l2都为空
        while (c1 != null || c2 != null) {
            int sum = ((c1 == null) ? 0 : c1.val) + ((c2 == null) ? 0 : c2.val) + add;
            ListNode node = new ListNode(sum % 10);
            tail.next = node;
            tail = tail.next;
            add = sum / 10 ;
            c1 = (c1 == null) ? null : c1.next;
            c2 = (c2 == null) ? null : c2.next;
        }
        if (add == 1)
            tail.next = new ListNode(1);
        return head.next;
        
    }
	
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        int sum;
        while (l1Current != null) {
            
            sum = l1Current.val + l2Current.val;
            if (sum >= 10) { 
                if (l1Current.next == null) {
                    l1Current.next = new ListNode(1);
                } else {
                    l1Current.next.val += 1;
                }
            }
            l1Current.val += sum % 10;
            if (l1Current.next == null) {
                l1Current.next = l2Current.next;
                return l1;
            }
            l1Current = l1Current.next;
            l2Current = l2Current.next;
            if (l2Current == null) {
                return l1;
            }
        }
        
        
        return l1;
	}
}

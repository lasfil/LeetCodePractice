package com.cyandragon.leetcode;
/** 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists. 
 */

public class MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode head = null;
        ListNode cur1 = null;
        ListNode cur2 = null;
        ListNode temp = null;
        if (l1.val < l2.val) {
            head = l1;
            cur2 = l2;
        } else {
            head = l2;
            cur2 = l1;
        }
        cur1 = head;
        
        while (cur1.next != null) {
            if (cur2 == null)
                break;
            if (cur2.val <= cur1.next.val) {
                temp = cur2;
                cur2 = cur2.next;
                temp.next = cur1.next;
                cur1.next = temp;
                cur1 = cur1.next;
            } else
                cur1 = cur1.next;
        }
        
        if (cur2 != null)
            cur1.next = cur2;
        
        return head;
    }
}

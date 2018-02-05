package com.zinkirin;
import java.util.List;


/** 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 *
 */
public class MergeKSortedList {
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        int size = lists.size();
        if (size == 1)
            return lists.get(0);
        
        while (size > 1) {
            for (int i = 0; i < lists.size(); i++) {
                if (i + 1 < lists.size()) {
                    ListNode tmp = lists.get(i + 1);
                    lists.remove(i + 1);
                    lists.set(i, merge(lists.get(i), tmp));
                }
            }
            
            size = lists.size();
        }
        ListNode head = lists.get(0);
        lists.clear();
        lists = null;
        return head;
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        if (h2 == null)
            return h1;
        if (h1 == null) {
            h1 = h2;
            return h1;
        }
        ListNode front = new ListNode(0);
        ListNode tail = front;
        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                 tail.next = h2;
                 h2 = h2.next;
            } else {
                tail.next = h1;
                h1 = h1.next;
            }
            tail = tail.next;
            tail.next = null;
        }
        
        if (h1 != null) {
            tail.next = h1;
        }
        if (h2 != null) {
            tail.next = h2;
            h2 = null;
        }
        
        h1 = front.next;
        tail = null;
        front.next = null;
        front = null;
        return h1;
    }
}

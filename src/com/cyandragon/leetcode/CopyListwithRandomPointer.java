package com.cyandragon.leetcode;

import org.junit.Test;

public class CopyListwithRandomPointer {
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode cur1 = head;
		RandomListNode cur2 = head;
		while (cur1 != null) {
			cur2 = new RandomListNode(cur1.label);
			cur2.next = cur1.next;
			cur1.next = cur2;
			cur1 = cur2.next;
		}
		cur1 = head;
		while (cur1 != null) {
			if (cur1.random != null) {
				cur1.next.random = cur1.random.next;
			}
			cur1 = cur1.next.next;
		}
		RandomListNode newHead = head.next;
		head.next = newHead.next;
		newHead.next = null;
		cur1 = head.next;
		cur2 = newHead;
		while (cur1 != null) {
			cur2.next = cur1.next;
			cur1.next = cur1.next.next;
			cur1 = cur1.next;
			cur2 = cur2.next;
			cur2.next = null;
			
		}
		return newHead;
	}

	@Test
	public void test() {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		n2.random = n4;
		n5.random = n3;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		copyRandomList(n1);
	}
}

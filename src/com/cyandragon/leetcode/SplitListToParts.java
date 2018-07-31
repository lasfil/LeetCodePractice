package com.cyandragon.leetcode;

import org.junit.Test;

public class SplitListToParts {
	@Test
	public void test() {
		ListNode root = new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
		splitListToParts(root, 3);
	}

	public static ListNode[] splitListToParts(ListNode root, int k) {
		if (root == null) {
			return new ListNode[0];
		}
		ListNode cur = root;
		int count = 0;
		while (cur != null) {
			cur = cur.next;
			count++;
		}
		int size = count / k;
		int remain = count % k;
		ListNode[] result = new ListNode[k];
		cur = root;
		for (int i = 0; i < k; i++) {
			ListNode start = cur;
			int len = size + (i < remain ? 1 : 0);
			ListNode end = cur;
			while (len > 1 && end != null) {
				end = end.next;
				len--;
			}
			result[i] = start;
			if (end == null) {
				break;
			}
			cur = end.next;
			end.next = null;
		}
		return result;
	}
}

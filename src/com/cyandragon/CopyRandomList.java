package com.cyandragon;
/*A linked list is given such that each node contains an additional 
 * random pointer which could point to any node in the list or null.
Return a deep copy of the list.*/
import java.util.HashMap;

public class CopyRandomList {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		HashMap<RandomListNode, RandomListNode> nodeCopyMap = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode cur = head;

		while (cur != null) {
			nodeCopyMap.put(cur, new RandomListNode(cur.label));
			cur = cur.next;
		}

		cur = head;
		RandomListNode newHead = nodeCopyMap.get(head);
		RandomListNode newCur = newHead;
		while (cur != null) {
			newCur.next = nodeCopyMap.get(cur.next);
			if (cur.random != null) {
				newCur.random = nodeCopyMap.get(cur.random);
			}
			cur = cur.next;
			newCur = newCur.next;
		}

		return newHead;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}

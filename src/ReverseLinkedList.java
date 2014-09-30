/** 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL. 
 */

public class ReverseLinkedList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n) {
			return head;
		}

		ListNode front = new ListNode(0);
		front.next = head;

		ListNode mNode = front;
		ListNode nNode = front;

		int i = 0;
		while (i < n) {
			nNode = nNode.next;
			i++;
			if (i < m)
				mNode = mNode.next;
		}

		ListNode mNext = null;

		while (mNode.next != nNode) {
			mNext = mNode.next;
			mNode.next = mNext.next;
			mNext.next = nNode.next;
			nNode.next = mNext;
		}
		head = front.next;
		return head;

	}
}
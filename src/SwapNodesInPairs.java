/** 
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode front = new ListNode(0);
		front.next = head;

		ListNode first = front;
		ListNode second = null;
		while (first.next != null && first.next.next != null) {
			second = first.next.next;
			first.next.next = second.next;
			second.next = first.next;
			first.next = second;
			first = first.next.next;
		}
		head = front.next;
		front = null;
		first = null;
		second = null;
		return head;
	}
}
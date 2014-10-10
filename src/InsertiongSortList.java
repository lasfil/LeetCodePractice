/**
 * Sort a linked list using insertion sort.
 * 
 */

public class InsertiongSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode front = new ListNode(0);
		front.next = head;
		ListNode cur = head;
		ListNode minor = null;
		ListNode insert = front;

		while (cur.next != null) {
			if (cur.next.val >= cur.val)
				cur = cur.next;
			else {
				minor = cur.next;
				cur.next = minor.next;

				while (insert.next.val < minor.val)
					insert = insert.next;
				minor.next = insert.next;
				insert.next = minor;
				insert = front;
			}
		}

		return front.next;
	}
}

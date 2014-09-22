/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class LinkedListToBST {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {

		return getSubTree(head, null);
	}

	public TreeNode getSubTree(ListNode head, ListNode tail) {
		if (head == tail) 
            return null;
        if (head.next == tail) {
            return new TreeNode(head.val);
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != tail && fast.next.next != tail ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        
        root.left = getSubTree(head, slow);
        
        root.right = getSubTree(slow.next, tail);
        
        return root;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode tail = head;
		tail.next = new ListNode(5);
		tail = tail.next;
		tail.next = new ListNode(8);
		tail = tail.next;
		TreeNode root = new LinkedListToBST().sortedListToBST(head);
	}
}

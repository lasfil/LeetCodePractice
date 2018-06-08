package com.zinkirin;
import java.util.Deque;
import java.util.LinkedList;


/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *   \   \
 *   3    3
 * Note:
 * 
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		

		queue.addFirst(root.left);
		queue.addLast(root.right);

		TreeNode lhead = null;
		TreeNode rhead = null;

		while (!queue.isEmpty()) {
			if (queue.size() % 2 == 1)
				return false;
			lhead = queue.pollFirst();
			rhead = queue.pollLast();

			if (lhead == null && rhead == null)
				continue;
			if (lhead == null && rhead != null)
				return false;
			if (lhead != null && rhead == null)
				return false;

			if (lhead.val != rhead.val)
				return false;

			queue.addFirst(lhead.right);

			queue.addFirst(lhead.left);

			queue.addLast(rhead.left);

			queue.addLast(rhead.right);

		}

		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(9, new TreeNode(-42, null, new TreeNode(
				76, null, new TreeNode(13))), new TreeNode(-42, new TreeNode(
				76, null, new TreeNode(13)), null));
		System.out.println(new SymmetricTree().isSymmetric(root));
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		TreeNode(int x, TreeNode left, TreeNode right) {
			val = x;
			this.left = left;
			this.right = right;
		}
	}
}

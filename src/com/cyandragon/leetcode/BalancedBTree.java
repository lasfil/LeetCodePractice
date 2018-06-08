package com.cyandragon.leetcode;
/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 */

public class BalancedBTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		return depth(root) != -1;
	}

	public int depth(TreeNode node) {
		if (node == null)
			return 0;

		int left = depth(node.left);
		if (left == -1)
			return -1;

		int right = depth(node.right);
		if (right == -1)
			return -1;

		if (Math.abs(left - right) > 1)
			return -1;

		return Math.max(left, right) + 1;
	}
}

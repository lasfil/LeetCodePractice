package com.cyandragon.leetcode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 *
 * 1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = 12 + 13 = 25.
 */

public class SumRootToLeaf {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;

		return sumChildren(root, 0, 0);
	}

	public int sumChildren(TreeNode node, int prefix, int sum) {

		prefix = prefix * 10 + node.val;
		if (node.left == null && node.right == null) {
			sum += prefix;
		}
		if (node.left != null) {
			sum = sumChildren(node.left, prefix, sum);
		}

		if (node.right != null) {
			sum = sumChildren(node.right, prefix, sum);
		}

		return sum;
	}
}

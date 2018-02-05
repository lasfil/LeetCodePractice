package com.zinkirin;

/** 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \      \
 *       7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class PathSum {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		private boolean result = false;
		private int sum;

		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null)
				return result;

			this.sum = sum;

			addPathSum(root, 0);

			return result;
		}

		public void addPathSum(TreeNode node, int pathSum) {
			if (node == null)
				return;

			pathSum += node.val;

			if (isLeaf(node)) {
				if (pathSum == this.sum) {
					this.result = true;
				}
			} else {
				if (node.left != null && !this.result) {
					addPathSum(node.left, pathSum);
				}

				if (node.right != null && !this.result) {
					addPathSum(node.right, pathSum);
				}
			}
		}

		private boolean isLeaf(TreeNode node) {
			return node != null && node.left == null && node.right == null;
		}
	}
}

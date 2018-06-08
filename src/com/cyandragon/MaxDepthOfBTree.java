package com.cyandragon;
/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthOfBTree {
	public int maxDepth(TreeNode root) {
        if (root == null) 
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}

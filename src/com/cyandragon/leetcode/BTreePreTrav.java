package com.cyandragon.leetcode;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class BTreePreTrav {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode n = stack.pop();
			result.add(n.val);
			if (n.right != null)
				stack.push(n.right);
			if (n.left != null)
				stack.push(n.left);
		}
		
		return result;
	}
}

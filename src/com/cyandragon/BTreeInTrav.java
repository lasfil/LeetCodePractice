package com.zinkirin;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
/**
 * For example: Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BTreeInTrav {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		Stack<TreeNode> s = new Stack<TreeNode>();

		TreeNode cur = root;

		do {
			s.push(cur);
			cur = cur.left;
		} while (cur != null);

		while (!s.isEmpty()) {
			cur = s.pop();

			result.add(cur.val);

			if (cur.right != null) {
				cur = cur.right;
				do {
					s.push(cur);
					cur = cur.left;
				} while (cur != null);
			}

		}

		return result;
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
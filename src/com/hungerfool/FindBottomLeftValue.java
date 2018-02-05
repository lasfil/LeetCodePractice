package com.hungerfool;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.*/
public class FindBottomLeftValue {
	public static int findBottomLeftValue() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		return findBottomLeftValue(root);
	}
	public static int findBottomLeftValue(TreeNode root) {
		List<TreeNode> current = new ArrayList<TreeNode>();
		List<TreeNode> next = new ArrayList<TreeNode>();
		next.add(root);
		while (!next.isEmpty()) {
			current.clear();
			current.addAll(next);
			next.clear();
			for (TreeNode t : current) {
				if (t.left != null) {
					next.add(t.left);
				}
				if (t.right != null) {
					next.add(t.right);
				}
			}
		}

		return current.get(0).val;
	}
}

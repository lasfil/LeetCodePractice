package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LowestCommonAncestor {
	@Test
	public void test() {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(4);
		TreeNode root = new TreeNode(6, new TreeNode(8, new TreeNode(0), new TreeNode(9, n1, new TreeNode(5))), n2);
		// new TreeNode(2, new TreeNode(7), n2));

		lowestCommonAncestor1(root, n1, n2);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}

		if (p.val > root.val && q.val > root.val) {
			lowestCommonAncestor(root.right, p, q);
		} else if (p.val < root.val && q.val < root.val) {
			lowestCommonAncestor(root.left, p, q);
		} else
			return root;

		return root;
	}

	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (p == root || q == root) {
			return root;
		}
		List<TreeNode> pPath = new ArrayList<TreeNode>();
		findPath(root, p, pPath);
		List<TreeNode> qPath = new ArrayList<TreeNode>();
		findPath(root, q, qPath);
		int i = 0;
		while (pPath.get(i) == qPath.get(i)) {
			i++;
		}
		return pPath.get(i - 1);
	}

	public boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
		if (root == null) {
			return false;
		}

		if (root == node) {
			path.add(node);
			return true;
		}

		if (findPath(root.left, node, path) || findPath(root.right, node, path)) {
			path.add(0, root);
			return true;
		}

		return false;
	}
}

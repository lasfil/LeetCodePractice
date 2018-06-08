package com.cyandragon;
import java.util.List;
import java.util.ArrayList;
/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 */
public class UniqueBST2 {
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

	public List<TreeNode> generateTrees(int n) {

		return generateTrees(1, n);

	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}
		if (start == end) {
			result.add(new TreeNode(start));
			return result;
		}

		List<TreeNode> left = null;
		List<TreeNode> right = null;
		for (int i = start; i <= end; i++) {
			left = generateTrees(start, i - 1);
			right = generateTrees(i + 1, end);

			for (TreeNode leftRoot : left) {
				for (TreeNode rightRoot : right) {
					TreeNode root = new TreeNode(i);
					root.left = leftRoot;
					root.right = rightRoot;
					result.add(root);
				}
			}
		}

		return result;
	}
}

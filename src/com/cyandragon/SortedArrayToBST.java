package com.cyandragon;
/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 */

public class SortedArrayToBST {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedListToBST(int[] num) {

		return getSubTree(0, num.length, num);
	}

	public TreeNode getSubTree(int head, int tail, int[] num) {
		if (head == tail)
			return null;
		if (head + 1 == tail) {
			return new TreeNode(num[head]);
		}

		int half = head + (tail - head) / 2;

		TreeNode root = new TreeNode(num[half]);

		root.left = getSubTree(head, half, num);

		root.right = getSubTree(half + 1, tail, num);

		return root;
	}

}

package com.cyandragon.leetcode;

/** 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {

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
	private TreeNode pre = null;
	public boolean isValidBST2(TreeNode root) {
		
		return  inorderTrav(root)== null;
	}

	private TreeNode inorderTrav(TreeNode root) {
		if (root == null)
			return null;
		TreeNode fault = inorderTrav(root.left);
		if (pre == null) {
			pre = root;
		} else {
			if (pre.val > root.val) 
				fault = pre;
			else
				pre = root;
		}
		fault = fault == null ? inorderTrav(root.right) : fault;
		return fault;
	}

	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;
		else if (root.left == null && root.right == null)
			return true;
		Boolean result = true;
		if (root.right != null) {
			TreeNode rightFirst = findRightFirst(root);
			if (rightFirst != null && rightFirst.val <= root.val)
				return false;
			result &= isValidBST(root.right) & root.right.val > root.val;
		}
		if (root.left != null) {
			TreeNode leftLast = findLeftLast(root);
			if (leftLast != null && leftLast.val >= root.val)
				return false;
			result &= isValidBST(root.left) & root.left.val < root.val;
		}

		return result;
	}

	public TreeNode findLeftLast(TreeNode root) {
		if (root == null || root.left == null)
			return null;

		TreeNode leftLast = root.left;

		while (leftLast.right != null) {
			leftLast = leftLast.right;
		}

		return leftLast;
	}

	public TreeNode findRightFirst(TreeNode root) {
		if (root == null || root.right == null)
			return null;

		TreeNode rightFirst = root.right;

		while (rightFirst.left != null) {
			rightFirst = rightFirst.left;
		}

		return rightFirst;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, null, new TreeNode(30, new TreeNode(10,
				null, new TreeNode(15, null, new TreeNode(45))), null));
		System.out.println(new ValidateBST().isValidBST(root));
	}
}
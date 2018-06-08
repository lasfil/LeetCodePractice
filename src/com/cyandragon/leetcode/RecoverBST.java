package com.cyandragon.leetcode;
/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note:
 * 
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBST {
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

	// public void recoverTree(TreeNode root) {
	// if (root == null)
	// return;
	// List<TreeNode> result = new ArrayList<TreeNode>();
	// List<TreeNode> left = validate(root.left, Integer.MIN_VALUE, root.val);
	//
	// List<TreeNode> right = validate(root.right, root.val, Integer.MAX_VALUE);
	// if (left.size() == 0 && right.size() == 1) {
	// swapVal(root, right.get(0));
	//
	// } else if (left.size() == 1 && right.size() == 0) {
	// swapVal(root, left.get(0));
	//
	// } else {
	// result.addAll(left);
	// result.addAll(right);
	// if (result.size() == 2) {
	// swapVal(result.get(0), result.get(1));
	// }
	// }
	//
	// }
	//
	// private List<TreeNode> validate(TreeNode root, int min, int max) {
	// List<TreeNode> result = new ArrayList<TreeNode>();
	// if (root == null)
	// return result;
	//
	// if (root.val > min && root.val < max) {
	// List<TreeNode> left = validate(root.left, min, root.val);
	//
	// List<TreeNode> right = validate(root.right, root.val, max);
	//
	// if (left.size() == 0 && right.size() == 1) {
	// swapVal(root, right.get(0));
	// return result;
	// } else if (left.size() == 1 && right.size() == 0) {
	// swapVal(root, left.get(0));
	// return result;
	// } else {
	// result.addAll(left);
	// result.addAll(right);
	// }
	// } else {
	// result.add(root);
	// }
	//
	// return result;
	// }
	//
	// public void swapVal(TreeNode n1, TreeNode n2) {
	// int temp = n1.val;
	// n1.val = n2.val;
	// n2.val = temp;
	// }
	TreeNode pre; // 指向当前遍历元素的前一个
	TreeNode first; // 第一个乱序的元素
	TreeNode second;// 第二个乱序的元素

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		if (pre == null) {
			pre = root;
		} else {
			if (pre.val > root.val) {
				if (first == null) {
					first = pre; // 找到第一个乱序的元素
				}
				second = root; // 第二个乱序的元素。如果用了else，则无法通过只有两个元素的情况
			}
			pre = root; // 继续搜索
		}
		inorder(root.right);
	}

	public void recoverTree(TreeNode root) {
		pre = null; // 必须在这里初始化一遍，否则OJ会报错
		first = null;
		second = null;
		inorder(root);
		if (first != null && second != null) { // 只需要交换元素值，而没必要进行指针操作！
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}
	}

	public static void main(String[] args) {
		TreeNode left = new TreeNode(6, new TreeNode(9), new TreeNode(7));
		left = new TreeNode(8, left, new TreeNode(5));
		left = new TreeNode(10, left, new TreeNode(13, new TreeNode(12),
				new TreeNode(16)));
		TreeNode right = new TreeNode(25, new TreeNode(19), new TreeNode(30));

		TreeNode root = new TreeNode(18, left, right);
		new RecoverBST().recoverTree(root);
	}
}

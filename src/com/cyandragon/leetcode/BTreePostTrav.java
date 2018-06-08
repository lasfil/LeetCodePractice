package com.cyandragon.leetcode;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class BTreePostTrav {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return null;
		TreeNode last = null;
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cursor = root;
		while (cursor != null) {
			stack.push(cursor);
			cursor = cursor.left;
		}

		while (!stack.isEmpty()) {

			TreeNode n = stack.peek();
			//该处理栈顶元素的时候，证明左子树已经遍历完成或者为空，
			//右子树为空或者等于last时候表示是刚遍历完右子树,或者右子树为空
			//此时应该最后遍历自己，所以将自己加入list并弹出，将自己设置为last
			// if (isLeaf(n) || n.right == null || n.right == last) {
			if (n.right == null || n.right == last) {
				result.add(n.val);
				last = n;
				stack.pop();
			// } else if (n.left == null || n.left == last){
			//else表示右子树不为空也不为last，此时则应该遍历右子树，将右子树的所有左子压入栈
			} else {
				cursor = n.right;
				while (cursor != null) {
					stack.push(cursor);
					cursor = cursor.left;
				}
			}
		}

		return result;
	}
}

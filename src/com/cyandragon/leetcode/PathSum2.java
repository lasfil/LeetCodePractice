package com.cyandragon.leetcode;
import java.util.List;
import java.util.ArrayList;

public class PathSum2 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private List<List<Integer>> pathes;
	private int sum;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		pathes = new ArrayList<List<Integer>>();
		if (root == null)
			return pathes;

		this.sum = sum;

		List<Integer> path = new ArrayList<Integer>();

		addPathSum(root, path, 0);

		return pathes;
	}

	public void addPathSum(TreeNode node, List<Integer> path, int pathSum) {
		pathSum += node.val;
		List<Integer> clone= new ArrayList<Integer>(path);
		clone.add(node.val);

		if (node.left != null) {
			addPathSum(node.left, new ArrayList<Integer>(clone), pathSum);
		} if (node.right != null) {
			addPathSum(node.right, new ArrayList<Integer>(clone), pathSum);
		} if(node.left == null && node.right == null){
			if (pathSum == this.sum) {
				pathes.add(path);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		
		
		new PathSum2().pathSum(root, 1);
	}
}

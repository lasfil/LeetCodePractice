package com.cyandragon.leetcode;
/** 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * 
 * Given n = 3, there are a total of 5 unique BST's.
 *
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 */

public class UniqueBST {
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
    public int numTrees(int n) {
        if (n <= 1)
            return 1;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += numTrees(i-1) * numTrees(n-i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(new UniqueBST().numTrees(4));
    }
}
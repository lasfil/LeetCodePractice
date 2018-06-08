package com.cyandragon.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) 
            return true;
        else if (p == null || q == null)
            return false;
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.addFirst(p);
        queue.addLast(q);
        
        TreeNode first = null;
        TreeNode last = null;
        
        while (!queue.isEmpty()) {
            first = queue.pollFirst();
            last = queue.pollLast();
            if (first == null && last == null)
                continue;
            else if (first == null || last == null)
                return false;
                
            if (first.val != last.val) 
                return false;
                
            queue.addFirst(first.right);
            queue.addFirst(first.left);
            queue.addLast(last.right);
            queue.addLast(last.left);
        }
        
        return true;
    }
    public static void main(String[] args) {
    	System.out.println(new SameTree().isSameTree(new TreeNode(0), new TreeNode(0)));
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
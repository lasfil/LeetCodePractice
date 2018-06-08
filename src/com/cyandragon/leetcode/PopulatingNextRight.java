package com.cyandragon.leetcode;
public class PopulatingNextRight {
	public void connect(TreeLinkNode root) {
		if (root == null)
            return;
        
        if (root.left != null) {
            root.left.next = root.right;
        }
        
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
	}
	
	public static void main(String[] args) {
		
		TreeLinkNode left = new TreeLinkNode(2);
		left = new TreeLinkNode(0,left, null);
		TreeLinkNode right = new TreeLinkNode(7);
		right = new TreeLinkNode(0,right, null);
		right = new TreeLinkNode(7,new TreeLinkNode(1), right);
		left = new TreeLinkNode(1,left, right);
		right = new TreeLinkNode(8);
		right = new TreeLinkNode(1,new TreeLinkNode(8), right);
		right = new TreeLinkNode(3,new TreeLinkNode(9), right);
		TreeLinkNode root = new TreeLinkNode(2,left, right);
		new PopulatingNextRight().connect(root);
	}
	
	
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
	
	TreeLinkNode(int x, TreeLinkNode left, TreeLinkNode right) {
		val = x;
		this.left = left;
		this.right = right;
	}
}
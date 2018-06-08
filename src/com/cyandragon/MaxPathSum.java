package com.zinkirin;
public class MaxPathSum {
	private int max = Integer.MIN_VALUE;
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public int maxPathSum(TreeNode root) {
	    if (root == null)
	        return 0;
	    
	    maxChildSum(root);
	    
	    return max;
	}
	public int maxChildSum(TreeNode node) {
        if (node == null)
            return 0;
        int val = node.val;
        
        int left = maxChildSum(node.left);
        int right = maxChildSum(node.right);
        //节点作为孩子节点考虑，是父节点向下调用求最大路径，是以下几种情况中得最大值：
        // val, val+left, val+right
        // 所以求出这三个中得最大值最为返回值
        int returnVal = Math.max(val,
                            Math.max(val + left, val + right));
      //此题需要遍历树上每一个节点，对于任何一个节点作为树，通过它的最大路径是以下几种情况之中的最大值：
        // val, val+left+right, val+left, val+right
        // 当得出子树最大路径得时候跟其他遍历过的子树中当前最大值max比较，如果比max大则更新max
        max = Math.max(max, 
                    Math.max(returnVal, val + left + right));
        
        return returnVal;
        
    }
	/*

	public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val;
        if (isLeaf(root))
            return sum;
        
        int left = 0;
        int right = 0;
        
        if (root.left != null) {
            left = maxChildSum(root.left);
            sum = Math.max(left + sum, Math.max(left, sum));
        }
        
        if (root.right != null) {
            right = maxChildSum(root.right);
            sum = Math.max(right + sum, Math.max(right, sum));
        }
        return  sum;
    }
    
    public int maxChildSum(TreeNode node) {
        
       
        int sum = node.val;
        if (isLeaf(node))
            return sum;
            
        int left = 0;
        int right = 0;
        
        if (node.left != null) {
            left = maxChildSum(node.left);
            sum = Math.max(left + sum, sum);
        }
        
        if (node.right != null) {
            right = maxChildSum(node.right);
            sum = Math.max(right + sum, sum);
        }
        
        return sum;
        
    }
    
    public boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }*/
}

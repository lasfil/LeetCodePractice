/** 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *  /   \
 * 15    7
 * return its bottom-up level order traversal as:
 * [
 *  [15,7]
 *  [9,20],
 *  [3],
 * ]
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BTreeLevelOrderTrav {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> child = new LinkedList<TreeNode>();
        List<Integer> level = new ArrayList<Integer>();
        q.offer(root);
        TreeNode head = null;
        while (!q.isEmpty()) {
            head = q.poll();
            
            level.add(head.val);
            if (head.left != null)
                child.offer(head.left);
            if (head.right != null)
                child.offer(head.right);
            if (q.isEmpty()) {
                while (!child.isEmpty())
                	q.offer(child.poll());
                result.add(level);
                level = new ArrayList<Integer>();
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		
		TreeNode left = new TreeNode(4);
		left = new TreeNode(left, new TreeNode(5), 2);
		TreeNode root = new TreeNode(left, new TreeNode(3),1);
		System.out.println(new BTreeLevelOrderTrav().levelOrder(root));
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		TreeNode(TreeNode left, TreeNode right,int x) {
			val = x;
			this.left = left;
			this.right = right;
		}
	}
}


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
public class FlattenBTreeToLinkedList {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	    public void flatten(TreeNode root) {
	        if (root == null ||     
	                (root.left == null && root.right == null))
	            return;
	        Iterator<TreeNode> i = preOrderIterator(root);
	        root =  i.next();
	        TreeNode cur = root;
	        cur.left = null;
	        while (i.hasNext()) {
	            cur.right = i.next();
	            cur = cur.right;
	            cur.left = null;
	        }
	    }
	    
	    public Iterator<TreeNode> preOrderIterator(TreeNode root) {
	        List<TreeNode> list = new ArrayList<TreeNode>();
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        stack.push(root);
	        TreeNode temp = null;
	        while (!stack.isEmpty()) {
	            temp = stack.pop();
	            list.add(temp);
	            if (temp.right != null)
	                stack.push(temp.right);
	            if (temp.left != null)
	                stack.push(temp.left);
	        }
	        
	        return list.iterator();
	    }
	}
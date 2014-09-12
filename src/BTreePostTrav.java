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
			if (isLeaf(n) || n.right == null || n.right == last) {
				result.add(n.val);
				last = n;
				stack.pop();
			} else if (n.left == null || n.left == last){
				cursor = n.right;
				while (cursor != null) {
					stack.push(cursor);
					cursor = cursor.left;
				}
			}
		}

		return result;
	}

	private boolean isLeaf(TreeNode n) {
		return (n != null && n.left == null && n.right == null);
	}
	
	
}

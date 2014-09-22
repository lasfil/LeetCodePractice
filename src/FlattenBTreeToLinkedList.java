
/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 *
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 */
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
        flattenSubtree(root);
    }
    
    public TreeNode flattenSubtree(TreeNode node) {
        
        if ( node == null || isLeaf(node) ) {
            return node;
        } 
        TreeNode right = node.right;
        TreeNode leftLast = node.left;
        
        if (leftLast != null) {
        	//左孩子为树的话递归调用，将左孩子flatten，返回最末端
        	//左孩子为叶子的话不动
            if (!isLeaf(leftLast))
            leftLast = flattenSubtree(node.left);
//            左孩子放到右边，左孩子的末端链接右孩子
//            将左孩子设置为空
            node.right = node.left;
            node.left = null;
            leftLast.right = right;
        }
            
        
        TreeNode rightLast = right;
        if (rightLast != null && !isLeaf(rightLast))
        	//右孩子为树的话继续递归flatten右孩子
            rightLast = flattenSubtree(right);
        
        return right == null ? leftLast : rightLast;
        
    }
    
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    

	/*public void flatten(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		Iterator<TreeNode> i = preOrderIterator(root);
		root = i.next();
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
	}*/
}
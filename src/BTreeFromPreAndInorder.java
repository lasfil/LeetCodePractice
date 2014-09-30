import java.util.Arrays;
/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * 
 * You may assume that duplicates do not exist in the tree.
 */

public class BTreeFromPreAndInorder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = preorder.length;
		if (len == 0)
			return null;
		TreeNode root = new TreeNode(preorder[0]);
		if (len == 1)
			return root;

		int index = search(inorder, preorder[0]);

		int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
		int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, len);

		if (inorderLeft.length > 0)
			root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
					inorderLeft);

		if (inorderRight.length > 0) {
			root.right = buildTree(
					Arrays.copyOfRange(preorder, index + 1, len), inorderRight);
		}

		return root;
	}
	
	private int search(int[] array, int num) {
		int result = -1;
		for (int i = 0; i < array.length; i++) {
			if (num == array[i]) {
				result = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] pre = new int[] {1, 2};
		int[] in = new int[] {2, 1};
		new BTreeFromPreAndInorder().buildTree(pre, in);
	}
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}


public class BTreeFromInAndPostorder {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int len = inorder.length;
		return buildFromSub(inorder, 0, len, postorder, 0, len);
	}

	public TreeNode buildFromSub(int[] inorder, int iStart, int iEnd,
			int[] postorder, int pStart, int pEnd) {
		int len = inorder.length;
		if (len == 0 || iStart < 0 || iEnd > len || pStart < 0 || pEnd > len)
			return null;
		TreeNode root = new TreeNode(postorder[pEnd - 1]);
		if (pEnd - pStart == 1)
			return root;

		int index = search(inorder, iStart, iEnd, postorder[pEnd - 1]);
		if (index > iStart)
			root.left = buildFromSub(inorder, iStart, index, postorder, pStart,
					pStart + index - iStart);
		if (index < iEnd - 1)
			root.right = buildFromSub(inorder, index + 1, iEnd, postorder,
					pStart + index - iStart, pEnd - 1);

		return root;
	}

	private int search(int[] array, int start, int end, int num) {
		int result = -1;
		for (int i = start; i < end; i++) {
			if (num == array[i]) {
				result = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] in = new int[] { 2, 1 };
		int[] post = new int[] {2, 1};

		new BTreeFromInAndPostorder().buildTree(in, post);
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

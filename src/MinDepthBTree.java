public class MinDepthBTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public int minDepth(TreeNode root) {
			int path = 0;

			if (root == null) {
				return path;
			}

			if (root.left == null && root.right == null)
				path = 1;
			else {
				if (root.left == null) {
					path = minDepth(root.right) + 1;
				} else if (root.right == null) {
					path = minDepth(root.left) + 1;
				} else {
					path = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
				}
			}

			return path;
		}
	}
}
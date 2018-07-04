package com.cyandragon.leetcode;

import org.junit.Test;

import com.google.gson.Gson;

public class SerializeAndDeserializeBinaryTree {
	@Test
	public void test() {
		TreeNode root = new TreeNode(6,
				new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
				new TreeNode(8, new TreeNode(7), new TreeNode(9)));
		System.out.println(serialize(root));
		Gson gson = new Gson();
		System.out.println(gson.toJson(root));
	}

	public int index = -1; // 节点在序列中的索引

	/**
	 * 序列化 前序遍历，将二叉树节点的值转为字符序列，null转为“#”
	 * 
	 * @param root
	 * @return
	 */
	static String serialize(TreeNode root) {
		StringBuffer s = new StringBuffer();
		if (root == null) {
			s.append("#,");
			return s.toString();
		}
		s.append(root.val + ",");
		s.append(serialize(root.left));
		s.append(serialize(root.right));
		return s.toString();
	}

	/**
	 * 反序列化
	 * 
	 * @param str
	 * @return
	 */
	TreeNode deserialize(String str) {
		index++;
		int length = str.length();
		if (index >= length) {
			return null;
		}
		String[] nodeSeq = str.split(",");
		TreeNode pNode = null;
		if (!nodeSeq[index].equals("#")) {
			pNode = new TreeNode(Integer.valueOf(nodeSeq[index]));
			pNode.left = deserialize(str);
			pNode.right = deserialize(str);
		}
		return pNode;
	}
}

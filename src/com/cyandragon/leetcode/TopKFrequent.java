package com.cyandragon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TopKFrequent {
	@Test
	public void test() {
		new TopKFrequent().topKFrequent(new int[] { -1, 1, 4, -4, 3, 5, 4, -2, 3, -1 }, 3);
	}

	class Node {
		int val;
		int count;

		Node(int val, int count) {
			this.val = val;
			this.count = count;
		}
		
		public String toString() {
			return val + " : " + count;
		}
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null) {
			return result;
		}

		Map<Integer, Node> frequency = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			Node n = frequency.getOrDefault(nums[i], new Node(nums[i], 0));
			n.count++;
			frequency.put(nums[i], n);
		}


		List<Node> temp = new ArrayList<Node>(frequency.values());
		buildHeap(temp, k - 1);
		for (int i = k; i < temp.size(); i++) {
			if (temp.get(i).count >= temp.get(0).count) {
				temp.set(0, temp.get(i));
				sink(temp, 0, k - 1);
			}
		}
		for (int i = 0; i < k; i++) {
			result.add(temp.get(i).val);
		}
		return result;

	}

	private void buildHeap(List<Node> list, int end) {
		for (int i = end / 2; i >= 0; i--) {
			sink(list, i, end);
		}
	}

	private void sink(List<Node> list, int node, int end) {
		if (node * 2 + 1 > end) {
			return;
		}
		int left = node * 2 + 1;
		int right = node * 2 + 2;
		int larger = left;
		if (right <= end && list.get(right).count < list.get(left).count) {
			larger = right;
		}
		if (list.get(node).count > list.get(larger).count) {
			Node temp = list.get(node);
			list.set(node, list.get(larger));
			list.set(larger, temp);
			sink(list, larger, end);
		}
	}
}

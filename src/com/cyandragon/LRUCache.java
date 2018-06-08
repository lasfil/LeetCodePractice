package com.zinkirin;

import java.util.Map;
import java.util.HashMap;

public class LRUCache {
	class Node {
		int key;
		int value;
		LRUCache.Node pre;
		LRUCache.Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {

			return "[" + key + "," + value + "]";
		}
	}

	private int capacity;
	private Map<Integer, Node> dataMap;
	private Node LRNode;
	private Node MRNode;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		dataMap = new HashMap<Integer, Node>();
	}

	public int get(int key) {
		Node n = dataMap.get(key);
		if (n == null) {
			return -1;
		} else {
			if (dataMap.size() > 1)
				updateMostRecent(n);
			return n.value;
		}
	}

	public void set(int key, int value) {
		if (dataMap.size() == 0) {
			Node n = new Node(key, value);
			dataMap.put(key, n);
			MRNode = n;
			LRNode = n;

		} else if (dataMap.keySet().contains(key)) {
			Node n = dataMap.get(key);
			n.value = value;
			dataMap.put(key, n);
			updateMostRecent(n);
		} else {
			Node n = new Node(key, value);
			if (dataMap.size() == capacity) {
				removeLastRecent();
				dataMap.put(key, n);
				updateMostRecent(n);
			} else {
				dataMap.put(key, n);
				updateMostRecent(n);
			}
		}
	}

	private void removeLastRecent() {
		Node nl = LRNode;

		if (dataMap.size() == 1) {
			LRNode = null;
			MRNode = null;
		} else {
			LRNode = nl.pre;
			LRNode.next = null;
		}
		dataMap.remove(nl.key);

	}

	private void updateMostRecent(Node n) {
		int size = dataMap.size();

		if (size == 1) {
			LRNode = n;
			MRNode = n;
		} else if (dataMap.size() > 1) {
			Node head = new Node(0,0);
			head.next = MRNode;
			MRNode.pre = head;
			
			Node tail = new Node(0,1);
			tail.pre = LRNode;
			LRNode.next = tail;
			if (n.pre != null)
				n.pre.next = n.next;
			if (n.next != null)
				n.next.pre = n.pre;
			n.pre = head;
			n.next = head.next;
			n.next.pre = n;
			
			head.next = n;
			MRNode = head.next;
			LRNode = tail.pre;
			head = null;
			tail = null;
		}

	}

	public String toString() {
		String result = "";
		for (Node n : dataMap.values())
			result = result + n;

		return result;
	}

	public static void main(String[] args) {
		LRUCache lc = new LRUCache(10);
		lc.set(10,13);
		lc.set(3,17);
		lc.set(6,11);
		lc.set(10,5);
		lc.set(9,10);
		lc.get(13);
		lc.set(2,19);
		lc.get(2);
		lc.get(3);
		lc.set(5,25);
		lc.get(8);
		lc.set(9,22);
		lc.set(5,5);
		lc.set(1,30);
		lc.get(11);
		lc.set(9,12);
		lc.get(7);
		lc.get(5);
		lc.get(8);
		lc.get(9);
		lc.set(4,30);
		lc.set(9,3);lc.get(9);lc.get(10);lc.get(10);lc.set(6,14);lc.set(3,1);
		lc.get(3);lc.set(10,11);lc.get(8);lc.set(2,14);lc.get(1);lc.get(5);
		lc.get(4);lc.set(11,4);lc.set(12,24);lc.set(5,18);lc.get(13);lc.set(7,23);lc.get(8);lc.get(12);lc.set(3,27);
		lc.set(2,12);lc.get(5);
		lc.set(2,9);
		lc.set(13,4);
		lc.set(8,18);
		lc.set(1,7);lc.get(6);lc.set(9,29);
		lc.set(8,21);lc.get(5);lc.set(6,30);lc.set(1,12);lc.get(10);lc.set(4,15);lc.set(7,22);lc.set(11,26);
		lc.set(8,17);lc.set(9,29);lc.get(5);lc.set(3,4);lc.set(11,30);lc.get(12);lc.set(4,29);
		lc.get(3);lc.get(9);lc.get(6);lc.set(3,4);lc.get(1);lc.get(10);lc.set(3,29);lc.set(10,28);lc.set(1,20);
		lc.set(11,13);lc.get(3);lc.set(3,12);lc.set(3,8);lc.set(10,9);lc.set(3,26);lc.get(8);lc.get(7);lc.get(5);
		lc.set(13,17);lc.set(2,27);lc.set(11,15);lc.get(12);lc.set(9,19);lc.set(2,15);lc.set(3,16);lc.get(1);lc.set(12,17);
		lc.set(9,1);lc.set(6,19);lc.get(4);lc.get(5);lc.get(5);lc.set(8,1);lc.set(11,7);lc.set(5,2);lc.set(9,28);lc.get(1);
		lc.set(2,2);lc.set(7,4);lc.set(4,22);lc.set(7,24);lc.set(9,26);lc.set(13,28);lc.set(11,26);
		
	}
}

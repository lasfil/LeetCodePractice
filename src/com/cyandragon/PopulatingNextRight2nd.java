package com.zinkirin;
public class PopulatingNextRight2nd {
	public void connect(TreeLinkNode root) {
//		if (root == null)
//			return;
//
//		TreeLinkNode level = root;
//		TreeLinkNode cur = level;
//		do {
//			for (cur = level; cur != null; cur = cur.next)
//				linkChild(cur);
//			level = nextLevel(level);
//		} while (level  != null);
		TreeLinkNode nextHead = new TreeLinkNode(99);
        nextHead.next = root;
        while(nextHead.next != null){
            TreeLinkNode tail = nextHead;
            TreeLinkNode n = nextHead.next;
            nextHead.next = null;
            for(; n != null; n = n.next){
                if(n.left != null){
                    tail.next = n.left;
                    tail = tail.next;
                }

                if(n.right != null){
                    tail.next = n.right; 
                    tail = tail.next;
                }
            }
        }

	}

	public void linkChild(TreeLinkNode node) {
		TreeLinkNode current = node;
		TreeLinkNode next = node.right;

		if (node.left != null) {
			while (next == null && current.next != null) {

				if (current.next.left != null) {
					next = current.next.left;
				} else if (current.next.right != null) {
					next = current.next.right;
				} else {
					current = current.next;
				}
			}
			node.left.next = next;
		}

		current = node.next;
		if (node.right != null && current != null) {
			next = current.left != null ? current.left : current.right;

			while (next == null && current.next != null) {
				if (current.next.left != null) {
					next = current.next.left;
				} else if (current.next.right != null) {
					next = current.next.right;
				} else {
					current = current.next;
				}
			}

			node.right.next = next;
		}
	}

	public TreeLinkNode nextLevel(TreeLinkNode level) {
		if (level == null)
			return null;
		if (level.left != null)
			return level.left;
		else if (level.right != null)
			return level.right;
		else
			return nextLevel(level.next);
	}
	
	public static void main(String[] args) {
		
		TreeLinkNode left = new TreeLinkNode(2);
		left = new TreeLinkNode(0,left, null);
		TreeLinkNode right = new TreeLinkNode(7);
		right = new TreeLinkNode(0,right, null);
		right = new TreeLinkNode(7,new TreeLinkNode(1), right);
		left = new TreeLinkNode(1,left, right);
		right = new TreeLinkNode(8);
		right = new TreeLinkNode(1,new TreeLinkNode(8), right);
		right = new TreeLinkNode(3,new TreeLinkNode(9), right);
		TreeLinkNode root = new TreeLinkNode(2,left, right);
		//TreeLinkNode root = new TreeLinkNode(1, new TreeLinkNode(8), null);
		new PopulatingNextRight2nd().connect(root);
	}
}

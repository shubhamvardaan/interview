package tree;

import java.util.Random;

public class BinaryTreeRandomNode {

	static class Node {
		int data;
		int children;
		Node left, right;

		public Node(int data) {

			this.data = data;
		}

	}

	static int getEle(Node root) {
		if (root == null)
			return 0;
		return getEle(root.left) + getEle(root.right) + 1;
	}

	static void setChildren(Node root) {
		if (root == null)
			return;
		root.children = getEle(root) - 1;
		setChildren(root.left);
		setChildren(root.right);
	}

	static int children(Node root) {
		if (root == null)
			return 0;
		return root.children + 1;
	}

	static int randomNode(Node root, int count) {
		int childCount = children(root.left);
		if (root == null)
			return 0;
		if (childCount == count)
			return root.data;
		else if (count < childCount)
			return randomNode(root.left, count);
		else
			return randomNode(root.right, count - children(root.left) - 1);

	}

	static int getRandomNode(Node root) {
		Random random = new Random();
		int count = random.nextInt(root.children + 1);
		return randomNode(root, count);
	}

	static Node makeBinaryTree() {
		Node root = new Node(54);
		root.left = new Node(34);
		root.right = new Node(67);
		root.left.left = new Node(23);
		root.left.right = new Node(45);
		root.right.left = new Node(123);
		root.right.right = new Node(342);
//		root.left.left.left = new Node(41);
//		root.left.left.right = new Node(31);
//		root.left.right.left = new Node(12);
//		root.left.right.right = new Node(11);
//		root.right.left.left = new Node(321);
//		root.right.left.right = new Node(76);
//		root.right.right.left = new Node(666);
//		root.right.right.right = new Node(321);
		return root;
	}

	public static void main(String[] args) {
		Node root = makeBinaryTree();
		setChildren(root);
		for (int i = 0; i < 100; i++)
			System.out.println(getRandomNode(root)+"  ");
	}

}

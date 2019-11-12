package threadedBinaryTree;

import java.util.LinkedList;

public class BTToThreaedBT {

	static ThreadedBT getLeftMostThreadedBT(ThreadedBT root) {
		ThreadedBT current = root;
		while (current!= null && current.left != null) {
			current = current.left;
		}
		return current;
	}

	static void insertInQueue(ThreadedBT root, LinkedList<ThreadedBT> queue) {
		if (root == null)
			return;
		if (root.left != null)
			insertInQueue(root.left, queue);
		queue.addLast(root);
		if (root.right != null)
			insertInQueue(root.right, queue);
	}

	static void createThreadedBinaryTreeUtil(ThreadedBT root, LinkedList<ThreadedBT> queue) {
		if (root == null)
			return;
		if (root.left != null)
			createThreadedBinaryTreeUtil(root.left, queue);
		queue.removeFirst();
		if (root.right != null)
			createThreadedBinaryTreeUtil(root.right, queue);
		else {
			root.right = queue.peek();
			root.isThreaded = true;
		}
	}

	static void inOrder(ThreadedBT root) {
		if (root == null)
			return;
		ThreadedBT curr = getLeftMostThreadedBT(root);
		while (curr != null) {
			System.out.print(root.data + "  ");
			if (root.isThreaded)
				curr = curr.right;
			else
				curr = getLeftMostThreadedBT(root.right);
		}
	}

	static void createThreadedBinaryTree(ThreadedBT root) {
		LinkedList<ThreadedBT> queue = new LinkedList<>();
		insertInQueue(root, queue);
		createThreadedBinaryTreeUtil(root, queue);
	}

	public static void main(String[] args) {
		ThreadedBT root = new ThreadedBT(1);
		root.left = new ThreadedBT(2);
		root.right = new ThreadedBT(3);
		root.left.left = new ThreadedBT(4);
		root.left.right = new ThreadedBT(5);
		root.right.left = new ThreadedBT(6);
		root.right.right = new ThreadedBT(7);

		createThreadedBinaryTree(root);
		System.out.println("Inorder traversal of created threaded tree");
		inOrder(root);
	}
}

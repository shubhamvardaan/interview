package tree;

import java.util.Deque;
import java.util.LinkedList;

public class AverageOfEachLevel {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static void levelAverage(Node root) {
		Deque<Node> d = new LinkedList<>();
		int currentNodeCount = 1;
		int nextLevelNodeCount = 0;
		float sum = 0;
		int count = 1;
		d.addLast(root);
		Node temp = null;
		while (!d.isEmpty()) {
			temp = d.pollFirst();
			sum = sum + temp.data;
			currentNodeCount--;
			if (temp.left != null) {
				d.addLast(temp.left);
				nextLevelNodeCount++;
			}
			if (temp.right != null) {
				d.addLast(temp.right);
				nextLevelNodeCount++;
			}
			if (currentNodeCount == 0) {
				currentNodeCount = nextLevelNodeCount;
				nextLevelNodeCount = 0;
				System.out.print(sum / count + " ");
				sum = 0;
				count = currentNodeCount;
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		levelAverage(root);
	}
}

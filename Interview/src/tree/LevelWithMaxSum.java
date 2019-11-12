package tree;

import java.util.HashMap;
import java.util.Map;

public class LevelWithMaxSum {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static void inorder(Node root, HashMap<Integer, Integer> shubham, int level) {
		if (root == null)
			return;

		if (!shubham.containsKey(level))
			shubham.put(level, root.data);
		else {
			int sum = shubham.get(level);
			shubham.remove(level);
			shubham.put(level, sum + root.data);
		}
		inorder(root.left, shubham, level + 1);
		inorder(root.right, shubham, level + 1);

	}

	static int levelWithMaxSum(Node root) {
		HashMap<Integer, Integer> shubham = new HashMap<>();
		int level = 0;
		inorder(root, shubham, level);
		int maxSum = Integer.MIN_VALUE;
		for (Map.Entry<Integer, Integer> map : shubham.entrySet()) {
			if (maxSum < map.getValue()) {
				level = map.getKey();
				maxSum = map.getValue();
			}
		}
		return level;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(12);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(6);
		root.left.right = new Node(8);
		root.right.right = new Node(30);
		System.out.println("level with maximum sum :" + levelWithMaxSum(root));
	}
}

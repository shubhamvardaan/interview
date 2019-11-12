package tree;

import java.util.LinkedList;
import java.util.List;

public class ExpressionTree {

	private static class TreeNode {
		Object data;
		TreeNode left, right;

		TreeNode(Object data) {
			this.data = data;
			left = right = null;
		}
	}

	static void preOrder(TreeNode root, List<Object> list) {
		if (root == null)
			return;
		preOrder(root.left, list);
		list.add(root.data);
		preOrder(root.right, list);
	}

	static int result(int first, int second, char c) {
		if (c == '/')
			return first / second;
		else if (c == '+')
			return first + second;
		else if (c == '-')
			return first - second;
		else
			return first * second;
	}

	static int evaluateTree(TreeNode root) {
		LinkedList<Object> list = new LinkedList<>();
		Integer firstOperand = null;
		Integer secondOperand = null;
		Character operator = null;
		preOrder(root, list);
		LinkedList<Object> stack = new LinkedList<>();
		while (!list.isEmpty()) {
			firstOperand = (Integer) list.removeFirst();
			operator = (Character) list.pollFirst();
			secondOperand = (Integer) list.pollFirst();
			int result = result(firstOperand, secondOperand, operator);
			stack.push(result);
			if (!list.isEmpty())
				stack.push(list.pollFirst());
		}
		firstOperand = (Integer) stack.removeFirst();
		operator = (Character) stack.removeFirst();
		firstOperand = (Integer) stack.removeFirst();
		return result(firstOperand, secondOperand, operator);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode('+');
		root.left = new TreeNode('*');
		root.right = new TreeNode('-');
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(19);
		System.out.println(evaluateTree(root));
	}
}

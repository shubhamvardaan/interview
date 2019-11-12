package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintTreeDiagonal {

	static void printDiagonalRecur(TreeNode root, Map<Integer, List<TreeNode>> shubham, int diagonal) {

		if (root == null)
			return;
		if (shubham.get(diagonal) == null) {
			List<TreeNode> list = new ArrayList<>();
			list.add(root);
			shubham.put(diagonal, list);
		} else
			shubham.get(diagonal).add(root);
		printDiagonalRecur(root.left, shubham, diagonal + 1);
		printDiagonalRecur(root.right, shubham, diagonal);
	}

	static void printTreeDiagonal(TreeNode root) {
		Map<Integer, List<TreeNode>> shubham = new HashMap<>();
		Integer diagonal = 0;
		printDiagonalRecur(root, shubham, diagonal);
		for (Map.Entry<Integer, List<TreeNode>> x : shubham.entrySet()) {
			for (TreeNode t : x.getValue()) {
				System.out.print(t.data + "  ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
		root.right.right = new TreeNode(61);
		root.left.right = new TreeNode(11);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(8);
		root.left.left.left = new TreeNode(100);
		printTreeDiagonal(root);
	}

}

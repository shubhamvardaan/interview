package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintTreeVericalOrder {

	static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	static void printVerticalOrder(TreeNode root, Map<Integer, List<TreeNode>> map, Integer distance) {

		if (root == null)
			return;
		printVerticalOrder(root.left, map, distance - 1);
		if (map.get(distance) == null) {
			List<TreeNode> array = new ArrayList<>();
			array.add(root);
			map.put(distance, array);
		} else {
			map.get(distance).add(root);
		}

		printVerticalOrder(root.right, map, distance + 1);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
		root.right.right = new TreeNode(61);
		root.left.right = new TreeNode(11);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(8);

		Map<Integer, List<TreeNode>> map = new HashMap<>();
		Integer distance = 0;
		printVerticalOrder(root, map, distance);
		System.out.println(map);
	}

}

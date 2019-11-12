package tree;

import java.util.*;

public class TopView {

	static void topView(TreeNode root, Map<Integer, List<TreeNode>> map, int distance) {
		if (root == null)
			return;
		if (map.get(distance) == null) {
			List<TreeNode> shubham = new ArrayList<>();
			shubham.add(root);
			map.put(distance, shubham);
		} else {
			map.get(distance).add(root);
		}
		topView(root.left, map, distance - 1);
		topView(root.right, map, distance + 1);
	}

	static List<Integer> topViewTree(TreeNode root) {
		Map<Integer, List<TreeNode>> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		int distance = 0;
		topView(root, map, distance);
		int minVal = Integer.MIN_VALUE;
		while (map.size() != 0) {
			minVal = Collections.min(map.keySet());
			list.add(map.get(minVal).get(0).data);
			map.remove(minVal);
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(69);
		root.left = new TreeNode(54);
		root.right = new TreeNode(70);
		root.right.right = new TreeNode(61);
		root.left.right = new TreeNode(11);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(8);
		System.out.println(topViewTree(root));
	}
}

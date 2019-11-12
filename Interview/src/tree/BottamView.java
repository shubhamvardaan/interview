package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BottamView {

	static void bottamView(TreeNode root, Map<Integer, List<TreeNode>> map, int distance) {
		if (root == null)
			return;
		if (map.get(distance) == null) {
			List<TreeNode> shubham = new ArrayList<>();
			shubham.add(root);
			map.put(distance, shubham);
		} else {
			map.get(distance).add(root);
		}
		bottamView(root.left, map, distance - 1);
		bottamView(root.right, map, distance + 1);
	}

	static List<Integer> bottamViewTree(TreeNode root) {
		Map<Integer, List<TreeNode>> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		int distance = 0;
		bottamView(root, map, distance);
		int minVal = Integer.MIN_VALUE;
		while (map.size() != 0) {
			minVal = Collections.min(map.keySet());
			list.add(map.get(minVal).get(map.get(minVal).size()-1).data);
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
		System.out.println(bottamViewTree(root));
	}

}

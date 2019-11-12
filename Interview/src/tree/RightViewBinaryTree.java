package tree;

import java.util.ArrayList;
import java.util.List;

public class RightViewBinaryTree {

	private static class shubham {
		 int max_level = -1;
	}
	
	static void rightViewUtil(TreeNode root, int level,shubham s, List<Integer> list) {
		if(root == null) return;
		if(s.max_level < level) {
			list.add(root.data);
			s.max_level = level;
		}
		
		rightViewUtil(root.right,level+1,s,list);
		rightViewUtil(root.left,level+1,s,list);
	}
	
	static List<Integer> rightView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		int level = 0;
		shubham s= new shubham();
		rightViewUtil(root,level,s,list);
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

		System.out.println(rightView(root));

	}

}

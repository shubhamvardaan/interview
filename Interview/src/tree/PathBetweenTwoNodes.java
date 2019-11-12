package tree;

import tree.LCABT.Node;

public class PathBetweenTwoNodes {

	static boolean printPaths(Node root, int a) {
		if (root == null)
			return false;
		if (root.data == a) {
			System.out.println(root.data + " ");
			return true;
		}
		if (printPaths(root.left, a) || printPaths(root.right, a)) {
			System.out.println(root.data + " ");
			return true;
		}
		return false;
	}

	static Node LCA(Node root, int a, int b) {
		if (root == null)
			return root;
		if (root.data == a || root.data == b)
			return root;
		Node left = LCA(root.left, a, b);
		Node right = LCA(root.right, a, b);

		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
	
	static void pathBetweenNodes(Node root, int a, int b) {
		Node lca = LCA(root,a,b);
		printPaths(lca,a);
		printPaths(lca,b);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(4);
		root.right.left= new Node(5);
		root.left.left= new Node(11);
		pathBetweenNodes(root,5,4);

	}

}

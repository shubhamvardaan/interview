package tree;

class number {
	int count = 1;
	int element = 0;
	boolean flag = false;
}

public class KthLargestElementBST {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}

		public void insert(Node root, int x) {
			if (root.data > x)
				if (left == null)
					left = new Node(x);
				else
					left.insert(left, x);
			else if (root.data < x)
				if (right == null)
					right = new Node(x);
				else
					right.insert(right, x);
		}
	}

	static void reversePreOrder(Node root, int k, number n) {

		if (root == null)
			return;
		reversePreOrder(root.right, k, n);
		if (k == n.count && !n.flag) {
			n.element = root.data;
			n.flag = true;
		}
		if (n.flag == true)
			return;
		n.count = n.count + 1;
		reversePreOrder(root.left, k, n);
	}

	static int getKthLargest(Node root, int k) {
		number n = new number();
		reversePreOrder(root, k, n);
		return n.element;
	}

	public static void main(String args[]) {
		int[] array = { 12, 19, 21, 2, 32, 7, 9, 10, 331 };
		Node root = new Node(12);
		for (int i = 1; i < array.length; i++)
			root.insert(root, array[i]);
		int k = 4;
		System.out.println(k + "th greatest element in bst :" + getKthLargest(root, k));

	}

}

package tree;

class shubham1 {
	int count = 1;
	int value = -1;
}

public class Tree {
	static class node {
		int data;
		node left, right;

		node(int data) {
			this.data = data;
		}

		public void insert(node root, int x) {
			if (root.data > x)
				if (left == null)
					left = new node(x);
				else
					left.insert(left, x);
			else if (root.data < x)
				if (right == null)
					right = new node(x);
				else
					right.insert(right, x);
		}

	}

	static void nthNode(node root, int n, shubham1 s) {
		if (root == null)
			return;
		nthNode(root.left, n, s);
		if (s.count == n) {
			s.value = root.data;

		}
		System.out.println(root.data + " ");
		s.count = s.count + 1;
		nthNode(root.right, n, s);
	}

	public static void main(String[] args) {
		int[] array = { 12, 19, 21, 2, 32, 7, 9, 10, 331 };
		node root = new node(12);
		shubham1 s = new shubham1();
		for (int i = 1; i < array.length; i++)
			root.insert(root, array[i]);
		nthNode(root, 3, s);
		System.out.println(s.value);
	}
}

package tree.Rank;

public class RankNode {
	int data;
	int left_count = 0;
	RankNode left;
	RankNode right;

	public RankNode(int data) {
		this.data = data;
	}

	public void insert(int x) {
		if (x < data) {
			if (left == null)
				left = new RankNode(x);
			else
				left.insert(x);
			left_count++;
		} else if (data < x) {
			if (right == null)
				right = new RankNode(x);
			else
				right.insert(x);
		}
	}

	public int getRank(int x) {
		if (data == x)
			return left_count;
		else if (x < data) {
			if (left == null)
				return -1;
			else
				return left.getRank(x);
		} else {
			int right_count = right == null ? -1 : right.getRank(x);
			if (right_count == -1)
				return right_count;
			else
				return 1 + left_count + right_count;
		}
	}
}

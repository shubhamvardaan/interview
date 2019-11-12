package tree.Rank;

public class Result {
	public static void main(String[] args) {
		RankNode root = null;
		int[] shubham = { 10, 8, -1, 71, 6, 100, 87, 21, -24 };
		int len = shubham.length;
		for (int i = 0; i < len; i++) {
			if (root == null)
				root = new RankNode(shubham[i]);
			else
				root.insert(shubham[i]);
		}
		System.out.println(root.getRank(6));
	}
}

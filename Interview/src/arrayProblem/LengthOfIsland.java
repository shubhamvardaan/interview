package arrayProblem;

class shubham {
	int count = 0;
}

public class LengthOfIsland {
	final static int[] offsets = { -1, 0, +1 };

	private boolean neighborExists(int[][] matrix, int i, int j) {
		if ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length)) {
			if (matrix[i][j] == 1) {
				return true;
			}
		}
		return false;
	}

	private void doDFS(int[][] matrix, int i, int j, boolean[][] visited, shubham s) {
		if (visited[i][j]) {
			return;
		}

		// mark this vertex as visited and visit all its neighbors in depth first manner
		visited[i][j] = true;
		s.count = s.count + 1;

		int xOffset, yOffset;
		for (int l = 0; l < offsets.length; l++) {
			xOffset = offsets[l];
			for (int m = 0; m < offsets.length; m++) {
				yOffset = offsets[m];

				// do not consider vertex[i][j] as its own neighbor
				if (xOffset == 0 && yOffset == 0) {
					continue;
				}

				// check if there exists a vertex at this offset and check if it is '1'
				if (neighborExists(matrix, i + xOffset, j + yOffset)) {
					doDFS(matrix, i + xOffset, j + yOffset, visited, s);
				}
			}
		}
	}

	public int findLengthofClusters(int[][] matrix) {
		// JVM initializes all values to false by default.
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		shubham s = new shubham();
		doDFS(matrix, 0, 0, visited, s);
		return s.count;

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 0, 1, 1 }, };

		LengthOfIsland solution = new LengthOfIsland();

		System.out.println(solution.findLengthofClusters(matrix));
	}
}

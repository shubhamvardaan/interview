package dynamicprogramming;

public class PartitionProblem {
	private boolean partitionPossible(int requiredSum, int[] set) {
		boolean[][] solution = new boolean[requiredSum + 1][set.length + 1];

		int numRows = requiredSum + 1, numCols = set.length + 1;

		for (int j = 0; j < numCols; j++) {
			solution[0][j] = true;
		}
		for (int i = 1; i < numRows; i++) {
			solution[i][0] = false;
		}

		for (int j = 1; j < numCols; j++) {
			for (int i = 0; i < numRows; i++) {
				if (solution[i][j - 1] == true) {
					solution[i][j] = true;
					if (((i + set[j - 1]) < numRows)) {
						solution[(i + set[j - 1])][j] = true;
					}
				} else if (solution[i][j] != true) {
					solution[i][j] = false;
				}

			}
		}

		return solution[numRows - 1][numCols - 1];
	}

	public boolean partitionExists(int[] set) {
		int sum = 0;
		for (int i = 0; i < set.length; i++) {
			sum += set[i];
		}
		if ((sum % 2) != 0) {
			return false;
		}
		return partitionPossible(sum / 2, set);
	}

	public static void main(String[] args) {
		PartitionProblem solution = new PartitionProblem();

		int[] set = { 7, 5, 3, 5 };

		System.out.println(solution.partitionExists(set));
	}
}
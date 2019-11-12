package recursion;

public class PartitionProblem {
	private boolean partitionPossible(int requiredSum, int currIndex, int[] set) {

		if (requiredSum == 0) {
			return true;
		}

		if (currIndex == set.length) {
			return false;
		}

		return (partitionPossible(requiredSum - set[currIndex], currIndex + 1, set)
				|| partitionPossible(requiredSum, currIndex + 1, set));
	}

	public boolean partitionExists(int[] set) {
		int sum = 0;
		for (int i = 0; i < set.length; i++) {
			sum += set[i];
		}

		if ((sum % 2) != 0) {
			return false;
		}
		return partitionPossible(sum / 2, 0, set);
	}

	public static void main(String[] args) {
		PartitionProblem solution = new PartitionProblem();

		int[] set = { 15, 5, 15, 20, 45 };

		System.out.println(solution.partitionExists(set));
	}
}

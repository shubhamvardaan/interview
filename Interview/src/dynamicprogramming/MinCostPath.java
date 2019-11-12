package dynamicprogramming;

public class MinCostPath {

	static int N = 4;

	static int minCostPath(int[][] table) {
		int[] arr = new int[N];
		arr[0] = 0;
		arr[1] = table[0][1];
		for (int i = 2; i < N; i++) {
			arr[i] = table[0][i];
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j] + table[i][i]) {
					arr[i] = arr[j] + table[j][i];
				}
			}
		}

		return arr[N - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] table = { { 0, 10, 75, 94 }, { -1, 0, 35, 50 }, { -1, -1, 0, 80 }, { -1, -1, -1, 0 } };
		System.out.println(minCostPath(table));

	}

}

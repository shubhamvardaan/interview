package miscelleneous;

public class PrintPowerSet {
	static void printPowerSet(int[] arr) {
		int n = arr.length;
		double len = Math.pow(2, n);

		for (int i = 0; i < len; i++) {

			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0)
					System.out.print(arr[j]);

			}

			System.out.println();
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		printPowerSet(arr);
	}
}

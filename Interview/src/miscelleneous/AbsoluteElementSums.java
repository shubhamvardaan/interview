package miscelleneous;

public class AbsoluteElementSums {
	static int[] playingWithNumbers(int[] arr, int[] queries) {
		int[] result = new int[queries.length];
		int length = queries.length;
		int sum=1003756860 ;
		for (int i = 0; i < length; i++) {
			sum = 0;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = arr[j] + queries[i];
				sum = sum+Math.abs(arr[j]);
			}
			result[i] = sum;
		}
		return result;
	}

	static void printArr(int arr[]) {
		int length = arr.length;
		for (int i = 0; i < length; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -1, 2, -3 };
		int[] queries = { 1, -2, 3 };
		printArr(playingWithNumbers(arr, queries));
	}

}

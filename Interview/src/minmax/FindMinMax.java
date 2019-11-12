package minmax;

public class FindMinMax {
	static void findMinMax(int[] arr) {
		int min = -1, max = -1;
		int length = arr.length;
		for (int i = 0; i < length - 1; i = i + 2) {
			if (arr[i] < arr[i + 1]) {
				if (min > arr[i])
					min = arr[i];
				if (max < arr[i + 1])
					max = arr[i + 1];
			} else {
				if (min > arr[i + 1])
					min = arr[i + 1];
				if (max < arr[i])
					max = arr[i];

			}
		}

		System.out.println(min + " " + max);
	}

	public static void main(String[] args) {
		int arr[] = { 21, 4, 12, -1, 47 };
		findMinMax(arr);
	}
}

package arrayProblem;

public class SegregateOddEvenWithInsertionOrder {

	static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	static void reverse(int[] array, int low, int high) {
		while (low < high) {
			swap(array, low, high);
			low++;
			high--;
		}
	}

	static void merge(int[] array, int low, int mid, int high) {
		int i = low, j = mid + 1;
		while (i <= mid && array[i] % 2 == 1)
			i++;
		while (j <= high && array[j] % 2 == 1)
			j++;
		reverse(array, i, mid);
		reverse(array, mid + 1, j - 1);
		reverse(array, i, j - 1);

	}

	static void segregateOddEven(int[] array, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			segregateOddEven(array, low, mid);
			segregateOddEven(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}

	static void printArray(int[] array) {
		for (int x : array) {
			System.out.print(x + "  ");
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 5, 13, 9, 10, 16, 86, 42, 90, 102, 109 };
		segregateOddEven(array, 0, array.length - 1);
		printArray(array);
	}

}

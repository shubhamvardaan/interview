package arrayProblem;

public class PrintFrequency {

	static void printFreq(int arr[]) {
		int n = arr.length;
		int pos = 0;
		while (pos < n) {
			int expectedPos = arr[pos] - 1;
			if (arr[pos] > 0 && arr[expectedPos] > 0) {
				int temp = arr[pos];
				arr[pos] = arr[expectedPos];
				arr[expectedPos] = temp;

				arr[expectedPos] = -1;
			} else if (arr[pos] > 0) {
				arr[expectedPos]--;
				arr[pos++] = 0;
			} else {
				pos++;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(i + 1 + " " + Math.abs(arr[i]));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 3, 3, 2, 5 };
		printFreq(arr);

	}

}

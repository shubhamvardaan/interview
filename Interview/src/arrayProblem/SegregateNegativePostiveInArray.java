package arrayProblem;

public class SegregateNegativePostiveInArray {

	public void printArr(int[] arr) {
		for (int x : arr) {
			System.out.print(x + "  ");
		}
	}

	public void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public void segregateArray(int[] arr) {
		int length = arr.length;
		int count = -1;
		for (int i = 0; i < length; i++) {
			if (arr[i] < 0) {
				count++;
				swap(arr, count, i);
			}
		}
		printArr(arr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, -11, 9, 43, -7, 9, 90, 23, -100 };
		new SegregateNegativePostiveInArray().segregateArray(arr);

	}

}

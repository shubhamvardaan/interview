package arrayProblem;

public class MajorityElement {
	static void majorityElement(int[] arr) {

		int count = 1;
		int first = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (first == arr[i]) {
				count = count++;
			} else if (first != arr[i]) {
				if (count == 1)
					first = arr[i];
				else
					count--;
			}
		}
		System.out.println(first);
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 7, 1, 3, 7, 3, 7, 1, 7, 7 };
		majorityElement(arr);
	}
}

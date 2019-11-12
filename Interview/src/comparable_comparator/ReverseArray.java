package comparable_comparator;

public class ReverseArray {
	static int[] reverseArray(int[] a) {
		int low = 0;
		int high = a.length;
		while (low < high) {
			int temp = a[low];
			a[low] = a[high];
			a[high] = temp;
			low++;
			high--;
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = { 12, 1, 2, 1, 3 };
		a = reverseArray(a);
		System.out.println(a);
	}
}

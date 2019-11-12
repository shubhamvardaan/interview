package minmax;

public class TournamentToFindMinMax {
	static class Minmax {
		int min;
		int max;

		Minmax(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	static Minmax getMinMax(int arr[], int low, int high) {
		int minimum, maximum;
		int mid;
		Minmax one, two;
		if (low == high) {
			return new Minmax(arr[low], arr[high]);
		}

		mid = low + (high - low) / 2;
		one = getMinMax(arr, low, mid);
		two = getMinMax(arr, mid + 1, high);

		if (one.min < two.min)
			minimum = one.min;
		else
			minimum = two.min;

		if (one.max < two.max)
			maximum = two.max;
		else
			maximum = one.max;
		return new Minmax(minimum, maximum);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1000, 11, 445, 1, 330, 3000, 10, -200 };
		Minmax result = getMinMax(arr, 0, arr.length - 1);
		System.out.println(result.min + " " + result.max);
	}
}

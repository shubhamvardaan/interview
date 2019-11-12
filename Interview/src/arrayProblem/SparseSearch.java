package arrayProblem;

public class SparseSearch {
	static int search(String[] array, int low, int high, String str) {
		if (high < low)
			return -1;
		int mid = low + (high - low) / 2;
		if (array[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < low && right > high)
					return -1;
				else if (right <= high && !array[right].isEmpty()) {
					mid = right;
					break;
				} else if (low <= left && !array[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
		if (array[mid].equals(str))
			return mid;
		else if (str.compareTo(array[mid]) < 0)
			return search(array, low, mid - 1, str);
		else
			return search(array, mid + 1, high, str);
	}

	static int search(String[] array, String str) {
		if (array == null || str == null || str.equals("")) {
			return -1;
		}
		return search(array, 0, array.length - 1, str);
	}

	public static void main(String[] args) {
		String[] array = { "", "shubham", "dog", "", "", "jar", "tiger", "vardaan", "", "computer" };
		String str = "vardaan";
		System.out.println(search(array, str));
	}
}

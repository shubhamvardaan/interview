package arrayProblem;

public class FindStringInArrayBinarySearch {
	static int search(String[] arr, String str, int start, int end) {
		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		if (arr[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < start && right > end)
					return -1;
				else if (right <= end && !arr[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= start && !arr[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
		if (str.equals(arr[mid])) {
			return mid;
		} else if (arr[mid].compareTo(str) < 0)
			return search(arr, str, mid + 1, end);
		else
			return search(arr, str, start, mid - 1);
	}

	static int search(String[] arr, String str) {
		if (arr == null || str == null || str == "")
			return -1;
		return search(arr, str, 0, arr.length-1);
	}

	public static void main(String[] args) {
		String[] arr = { "shubham", "", "test", "", "hyderabad", "", "patna" };
		System.out.println(search(arr, "test"));
	}

}

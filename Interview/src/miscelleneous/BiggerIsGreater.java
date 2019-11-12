package miscelleneous;

import java.util.Arrays;
import java.util.Comparator;

public class BiggerIsGreater {

	static void swap(char[] arr, int x, int y) {
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	static void getNextString(String s) {
		char[] arr = s.toCharArray();
		int len = arr.length;
		boolean flag = false;
		int i = 0, j = 0;
		for (i = len - 1; i > 0; i--) {
			for (j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
					flag = true;
					break;
				}
			}

			if (flag == true)
				break;
		}
		if (flag == true)
			Arrays.sort(arr, j + 1, arr.length);
		if (s.equals(String.valueOf(arr)))
			System.out.println("no answer");
		else
			System.out.println(String.valueOf(arr));
	}

	public static void main(String[] args) {
		String str = "dkhc";
		getNextString(str);
	}

}

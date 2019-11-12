package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

	static String swap(String str, int i, int j) {
		char[] a = str.toCharArray();
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return String.valueOf(a);
	}

	static boolean shouldSwap(char str[], int start, int curr) {
		for (int i = start; i < curr; i++) {
			if (str[i] == str[curr]) {
				return false;
			}
		}
		return true;
	}

	static void printPermutation(String str, int n, int k, List<String> results) {
		if (n == k) {
			results.add(str);
		} else {
			for (int i = n; i <= k; i++) {
				boolean check = shouldSwap(str.toCharArray(), n, i);
				if (check) {
					str = swap(str, n, i);
					printPermutation(str, n + 1, k, results);
					str = swap(str, n, i);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> results = new ArrayList<>();
		printPermutation("aaab", 0, "aaab".length() - 1, results);
		Collections.sort(results);
		System.out.println(results);
	}

}
